package ghar.learn.pluralsight.puretwo

import java.awt.event.MouseEvent
import java.awt.event.MouseListener

fun main(){

    println("using Companions...")
    val textView = TextView()

    textView.addTextViewClickListener(object : MouseListener {
        override fun mouseClicked(e: MouseEvent?) {
            TODO("Not yet implemented")
        }

        override fun mousePressed(e: MouseEvent?) {
            TODO("Not yet implemented")
        }

        override fun mouseReleased(e: MouseEvent?) {
            TODO("Not yet implemented")
        }

        override fun mouseEntered(e: MouseEvent?) {
            TODO("Not yet implemented")
        }

        override fun mouseExited(e: MouseEvent?) {
            TODO("Not yet implemented")
        }

    }


    )

}

class TextView {

    /**
     * below method demonstrated better pattern using 'anonymous 'Object', whereby the Interface
     * is passed as parameter, as 'Object'. That is 'inline-implementation' of the interface or 'anonymous',
     * hence, callbacks (implemented methods) are provided, withOut a separate (of class) object-instantiation
     */
    fun addTextViewClickListener(listener: MouseListener) {  }

}

/**
 * class-implementation-Approach that extends the 'MouseListener-an-Interface'
 * and provides all methods that are always created, separately consuming memory


class MyTextView : MouseListener() {

    override fun mouseClicked(e: MouseEvent?) {
        TODO("Not yet implemented")
    }

    override fun mousePressed(e: MouseEvent?) {
        TODO("Not yet implemented")
    }

    override fun mouseReleased(e: MouseEvent?) {
        TODO("Not yet implemented")
    }

    override fun mouseEntered(e: MouseEvent?) {
        TODO("Not yet implemented")
    }

    override fun mouseExited(e: MouseEvent?) {
        TODO("Not yet implemented")
    }

 }
 *
**/

