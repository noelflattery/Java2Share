package com.android;
/**
 * Base class for Hippo, PygmyHippo and Elephant
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/r5lDPx1dtFg">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @author NoelF
 *
 */
public class HeavyAnimal {

}
/**
 * sub class of HeavyAnimal which will be used with instanceof when we will have super class references to 
 * sub class objects
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/r5lDPx1dtFg">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @author NoelF
 *
 */
class Hippo extends HeavyAnimal{
	
}
/**
 * sub class of Hippo and HeavyAnimal which will be used with instanceof when we will have super class references to 
 * sub class objects. this class implements the Behaviour interface {@link com.android.Behaviour}
 * so {@code new.Hippo() instanceof Behaviour} 
 * will return true
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/r5lDPx1dtFg">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @author NoelF
 * @see com.android.Behaviour
 *
 */
class PygmyHippo extends Hippo implements Behaviour{
	
}
/**
 * sub class of HeavyAnimal which will be used with instanceof when we will have super class references to 
 * sub class objects
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/r5lDPx1dtFg">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @author NoelF
 *
 */
class Elephant extends HeavyAnimal{
	
}
/**
 * there is no relationship between the cow class and the other 
 * classes and interfaces in this file
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/r5lDPx1dtFg">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 */
class Cow{
	
}
