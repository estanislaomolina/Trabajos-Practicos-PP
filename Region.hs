module Region ( Region, newR, foundR, linkR, tunelR, connectedR, linkedR) --delayR, availableCapacityForR)
   where

import Point
import City
import Link
import Tunel
import Quality

data Region = Reg [City] [Link] [Tunel] deriving Show

newR :: Region
newR = Reg [] [] [] 

foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (Reg citylist linklist tunelist) city = (Reg (citylist ++ [city]) linklist tunelist)

linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR (Reg citylist linklist tunelist) city1 city2 quality = Reg citylist (linklist ++ [(newL city1 city2 quality)]) tunelist

checkcityR :: Region -> City -> Bool -- chequea si una ciudad pertenece a una region
checkcityR (Reg citylist _ _) citytarget = foldr (\each fold -> each == citytarget || fold ) False citylist

multicheckcityR :: Region -> [ City ] -> Bool -- chequea si todas las ciudades de la lista pertenecen a la region
multicheckcityR (Reg rcitylist rlinklist rtunelist) citylist = foldr(\each fold -> checkcityR (Reg rcitylist rlinklist rtunelist) each && fold ) True citylist

checklinkR :: Region -> [ City ] -> Bool
checklinkR (Reg rcitylist rlinklist rtunelist) citylist = foldr (\(each, next) fold -> linkedR (Reg rcitylist rlinklist rtunelist) each next && fold ) True (zip citylist (tail citylist))

tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
tunelR (Reg rcitylist rlinklist rtunelist) citylist | multicheckcityR (Reg rcitylist rlinklist rtunelist) citylist == False = error "Alguna ciudad no pertenece a la region"

connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
connectedR (Reg _ _ tunelist) city1 city2 = foldr (\each fold -> connectsT city1 city2 each  || fold ) False tunelist


linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
linkedR (Reg _ linklist _) city1 city2 = foldr (\each fold -> linksL city1 city2 each  || fold ) False linklist

--delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora

--availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades


p1 = newP 10 10
p2 = newP 8 10
p3 = newP 5 5
dist = difP p1 p2

c1 = newC "Atlanta" p1
c2 = newC "Chicago" p2
c3 = newC "New York" p3
nombre = nameC c1
distancia = distanceC c1 c2

q1 = newQ "good" 3 1
q2 = newQ "bad" 5 10
cap = capacityQ q1
del = delayQ q1

link1 = newL c1 c2 q1
link2 = newL c2 c3 q2
con1 = connectsL c2 link1
con2 = connectsL c3 link1

linkCon1 :: Bool
linkCon1 = linksL c1 c2 link1
linkCon2 = linksL c1 c3 link1
linkCon3 = linksL c2 c1 link1

capac = capacityL link1

dela = delayL link1

tunel1 = newT [link1]
tunel2 = newT [link2]

tunCon1 = connectsT c1 c2 tunel1
tunCon2 = connectsT c1 c3 tunel1
tunUse1 = usesT link1 tunel1 
tunUse2 = usesT link1 tunel2
tunDel1 = delayT tunel1

region1 = newR
region2 = foundR region1 c1
region3 = linkR region2 c1 c2 q1
region4 = foundR region3 c2

checkCit1 = checkcityR region4 c1 -- True
checkCit2 = checkcityR region4 c2 -- True
checkCit3 = checkcityR region4 c3 -- False

multcheckCit1 = multicheckcityR region4 [c1, c2]
multcheckCit2 = multicheckcityR region4 [c1, c2, c3]
multcheckCit3 = multicheckcityR region4 [c1, c3]
multcheckCit4 = multicheckcityR region4 [c2]

checkLin1 = checklinkR region4 [c1, c2] -- True
checkLin2 = checklinkR region4 [c1, c2, c3] -- False
checkLin3 = checklinkR region4 [c3] -- False
region5 = linkR region4 c3 c2 q2
checkLin4 = checklinkR region5 [c1, c2, c3] -- True
