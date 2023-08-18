module TestCode 
    where 

import Point
import City
import Quality
import Link

p1 = newP 10 10
p2 = newP 8 10
dist = difP p1 p2

c1 = newC "Atlanta" p1
c2 = newC "Chicago" p2
nombre = nameC c1
distancia = distanceC c1 c2