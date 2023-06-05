THIS WAS A COLLEGE PROJECT.

## Program

The cars are represented by threads. The most important class is the Bridge, which is made of two semaphores, green at the beginning. When a car arrives, if the semaphore of his direction is green he just goes on, but if it is not he waits till it is, and when it is he automatically wakes up, he turns the opposite direction's semaphore red and, since Semaphores are increased automatically when called by, and these are binary, he turns his own back on so cars coming behind him can cross.

Once on the bridge, there is a counter keeping track of the number of cars, just to turn the opposite semaphore green when the bridge is empty.

The program also has a static function just to check how it works, since debugging synchronous programs can be tricky.

I've dealt with resource management in 4 subjects now. I don't care if this implementation is standard or weird in a problematic way. I'm done with college and learning patterns that are overkill for simple programs and not enough for complex ones. I've come to realize the software development ecosystem can be quite disappointing. It can also not but...