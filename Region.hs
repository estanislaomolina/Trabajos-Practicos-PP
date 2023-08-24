module Region ( Region, newR, foundR, linkR, tunelR, connectedR, linkedR, delayR, availableCapacityForR)
   where

import City
import Link
import Tunel
import Quality

data Region = Reg [City] [Link] [Tunel]

newR :: Region
newR = Reg [] [] [] 

foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (Reg citylist _ _) city = reg ((city ++ [citylist]) _ _)

linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR (Reg citylist linklist tunelist) city1 city2 quality = Reg citylist ((newL city1 city2 quality)++[linklist]) tunelits

checkcityR :: Region -> City -> Bool -- chequea si una ciudad pertenece a una region
cityR (Reg citylist _ _) citytarget = foldr (\each fold -> each == citytarget || fold ) False citylist

multicheckcityR :: Region -> [ City ] -> Bool -- cheque si todas las ciudades de la lista pertenecen a la region
multicheckcityR (Reg regcitylist _ _) citylist = foldr(\each fold -> checkcityR (Reg regcitylist _ _) each || fold ) False citylist

checklinkR :: [ Link ] -> City -> City -> Bool
checklinkR linklist city1 city2 = foldr (\each fold -> city1 city2 each || fold ) False linklist

multichecklinkR :: [ Link ] -> [ City ] -> Bool
multichecklinkR linklist citylist = foldr (\(each, next) fold -> checklinkR linklist each next || fold ) False (zip citylist (tail citylist))

tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
tunelR (Reg regcitylist reglinklist regtunelist) citylist | multicheckcityR (Reg regcitylist _ _) citylist == False = error "Alguna ciudad no pertenece a la region"
                                                          | 

connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
connectedR (Reg _ _ tunelist) city1 city2 = foldr (\each fold -> connectsT city1 city2 each  || fold ) False tunelist


linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
linkedR (Reg _ linklist _) city1 city2 = foldr (\each fold -> connectsL city1 city2 each  || fold ) False linklist

delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora

availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades