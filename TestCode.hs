module TestCode 
    where 

import Point
import City
import Quality
import Link
import Tunel
import Region

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
addCit1 = foundR region1 c1
linR = linkR addCit1 c1 c2 q1