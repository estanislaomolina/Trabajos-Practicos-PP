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

region1 = (newR [atlanta, nyc, tokyo, miami, bsas] [link1,link2,link3,link4] [tunel1])

