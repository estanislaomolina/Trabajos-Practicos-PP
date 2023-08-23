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
tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
tunelR (Reg regcitylist reglinklist regtunelist) citylist | multicheckcityR (Reg regcitylist _ _) citylist == False = error "Alguna ciudad no pertenece a la region"
                                                          | 











connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades