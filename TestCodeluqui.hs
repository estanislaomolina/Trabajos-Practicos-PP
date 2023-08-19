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
p3 = newP 2 1
p4 = newP 1 1

dist = difP p1 p2

atlanta = newC "Atlanta" p1
nyc = newC "NYC" p2
tokyo = newC "Tokyo" p3
nagasaki = newC "Nagasaki" p4

good = newQ "Good" 3 1.5
bad = newQ "Bad" 1 0.5

link1 = newL atlanta nyc good

link2 = newL nagasaki tokyo bad

tunel1 = newT [link1,link2]

Asia = newR nyc good tunel1

