module Region ( Region, newR, foundR, linkR, tunelR, connectedR, linkedR, delayR) --availableCapacityForR)
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
multicheckcityR region@(Reg rcitylist rlinklist rtunelist) citylist = foldr(\each fold -> checkcityR region each && fold ) True citylist

savelinkR :: Region -> City -> City -> [Link]
savelinkR (Reg _ linklist _) city1 city2 = foldr (\each fold -> if linksL city1 city2 each then fold ++ [each] else fold) [] linklist

multisavelinkR :: Region -> [ City ] -> [Link]
multisavelinkR region@(Reg rcitylist rlinklist rtunelist) citylist = foldr (\(each, next) fold -> fold ++ (savelinkR region each next)  ) [] (zip citylist (tail citylist))

tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
tunelR region@(Reg rcitylist rlinklist rtunelist) citylist 
   | not (multicheckcityR region citylist)  = error "Hay por lo menos alguna ciudad no pertenece a la region" 
   | not (checklinkR region citylist) = error "Hay por lo menos algun par de ciudades que no estan conectadas por links"
   | not (foldr(\(each, next) fold -> (availableCapacityForR region each next > 0) && fold ) True (zip citylist (tail citylist))) = error "no hay capacidad suficiente en los links"
   | otherwise = Reg rcitylist rlinklist (rtunelist ++ [(newT (multisavelinkR region citylist ))])
      where 
         checklinkR :: Region -> [ City ] -> Bool
         checklinkR region@(Reg rcitylist rlinklist rtunelist) citylist = foldr (\(each, next) fold -> linkedR region each next && fold ) True (zip citylist (tail citylist))
                                                         


connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
connectedR (Reg _ _ tunelist) city1 city2 = foldr (\each fold -> connectsT city1 city2 each  || fold ) False tunelist

linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
linkedR (Reg _ linklist _) city1 city2 = foldr (\each fold -> linksL city1 city2 each || fold ) False linklist

delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
delayR region@(Reg _ _ tunelist) city1 city2 | connectedR region city1 city2 = foldr (\each fold -> delayT each + fold) 0 tunelist
                                             | otherwise = error "Estas ciudades no están conectadas por un tunel"

availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades
availableCapacityForR region@(Reg citylist linklist tunelist) city1 city2 
   | not (linkedR region city1 city2)= error "No hay un link entre estas dos ciudades" 
   | otherwise = if capacitycheck < 0 then 0 else capacitycheck
      where
         capacitycheck = (foldr (\each fold -> (+) (capacityL each) fold ) 0 usedlinklist) - (foldr (\each fold -> if usesT (head usedlinklist) each then fold + 1 else fold) 0 tunelist) 
         usedlinklist = (foldr (\each fold -> if linksL city1 city2 each then fold ++ [each] else fold ) [] linklist)


p1 = newP 10 10
p2 = newP 8 10
p3 = newP 2 1
p4 = newP 1 1
p5 = newP 3 3 
p6 = newP 7 7 


dist = difP p1 p2

atlanta = newC "Atlanta" p1
nyc = newC "NYC" p2
tokyo = newC "Tokyo" p3
miami = newC "Miami" p4
bsas = newC "Buenos Aires" p5
chicago = newC "Chicago" p6

ultra = newQ "Ultra" 10 1
prime = newQ "Prime" 5 2
super = newQ "Super" 4 3
good = newQ "Good" 3 4
mid = newQ "Mid" 2 5
unusable = newQ "unusable" 0 0

link1 = newL atlanta nyc good
link2 = newL nyc miami mid
link3 = newL miami tokyo super
link4 = newL tokyo bsas ultra
tunel1 = newT [link1,link2]
tunel2 = newT [link1,link2,link3,link4]
tunel3 = newT [link1,link3,link2,link4]

region1 = foundR newR atlanta
region2 = foundR region1 nyc
region3 = foundR region2 tokyo
region4 = foundR region3 miami
region5 = foundR region4 bsas

region6 = linkR region5 atlanta nyc unusable
region7 = linkR region6 nyc tokyo mid
region8 = linkR region7 tokyo miami good
region9 = linkR region8 miami bsas prime

region10 = linkR region6 tokyo miami mid
region11 = linkR region7 miami bsas super

region12 = linkR (foundR region9 chicago) nyc chicago ultra

citylist1 = [bsas, miami, tokyo, nyc, atlanta]
citylist2 = [bsas,       tokyo, nyc, atlanta]
citylist3 = [atlanta, nyc]
citylist4 = [miami, bsas]
citylist5 = [bsas, miami, tokyo, nyc, chicago]

--checklinkR1 = checklinkR region9 citylist1 -- Devuelve True
--checklinkR2 = checklinkR region11 citylist1 -- Devuelve False
--checklinkR3 = checklinkR region11 citylist4 -- Devuelve True 

tunelR1 = tunelR region9 citylist1 --Usa un link sin capacidad
tunelR2 = tunelR region11 citylist1 --Usa ciudades que no estan conectadas por links validos
tunelR3 = tunelR region12 citylist5 -- funcionamiento normal

delayR1 = delayR tunelR1 atlanta bsas
delayR2 = delayR tunelR2 atlanta bsas
delayR3 = delayR tunelR1 atlanta tokyo

availablecap1 = availableCapacityForR tunelR1 bsas atlanta 
availablecap2 = availableCapacityForR tunelR1 nyc atlanta
availablecap3 = availableCapacityForR tunelR1 miami bsas