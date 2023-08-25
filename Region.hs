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
p3 = newP 2 1
p4 = newP 1 1
p5 = newP 3 3 
p6 = newP 7 7 
p7 = newP 8 8
p8 = newP 9 9

dist = difP p1 p2

atlanta = newC "Atlanta" p1
nyc = newC "NYC" p2
tokyo = newC "Tokyo" p3
miami = newC "Miami" p4
bsas = newC "Buenos Aires" p5

bluelabel = newQ "Blue Label" 100 10
ultra = newQ "Ultra" 10 5
prime = newQ "Prime" 5 3
super = newQ "Super" 4 2 
good = newQ "Good" 3 1.5
mid = newQ "Mid" 2 1
bad = newQ "Bad" 1 0.5

link1 = newL atlanta nyc good
link2 = newL nyc miami mid
link3 = newL miami tokyo bad
link4 = newL tokyo bsas ultra

tunel1 = newT [link1,link2]
tunel2 = newT [link1,link2,link3,link4]
tunel3 = newT [link1,link3,link2,link4]

region1 = foundR newR atlanta
region2 = foundR region1 nyc
region3 = foundR region2 tokyo
region4 = foundR region3 miami
region5 = foundR region4 bsas

region6 = linkR region5 atlanta nyc bad
region7 = linkR region6 nyc tokyo mid
region8 = linkR region7 tokyo miami good
region9 = linkR region8 miami bsas prime

region10 = linkR region6 tokyo miami mid
reigon11 = linkR region7 miami bsas super

citylist1 = [bsas, miami, tokyo, nyc, atlanta]
citylist2 = [bsas,       tokyo, nyc, atlanta]
citylist3 = [atlanta, nyc]
citylist4 = [miami, bsas]



{- p1 = newP 10 10
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
 -}

