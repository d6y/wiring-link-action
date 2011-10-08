package code 
package snippet 

import net.liftweb.util._
import net.liftweb.common._
import java.util.Date
import code.lib._
import Helpers._

import net.liftweb.http._
import net.liftweb.util.ValueCell
import net.liftweb.http.js.JsCmds.Noop
import net.liftweb.http.js.jquery.JqWiringSupport

import scala.xml._
import scala.actors.Futures.future

class HelloWorld {
 
  private val thing1Ready = ValueCell[Boolean](false)
  private val thing2Ready = ValueCell[Boolean](false)

  private val canContinue = thing1Ready.lift(thing2Ready)( _ && _)
    
  private def slow(title: String)(thunk: => NodeSeq): NodeSeq = {
 	 val delay = 1000L + randomLong(10000)
 	 println( "%s sleeping for %s".format(title,delay) )
 	 Thread.sleep(delay)
 	 thunk
  }

  def thing1: NodeSeq = slow("thing 1") {
  	thing1Ready set true
  	<div>42</div>
  }

  def thing2: NodeSeq = slow("thing 2") {
  	thing2Ready set true
  	<div>103</div>
  }

  def simpleLink(in: NodeSeq): NodeSeq = SHtml.link("/static/", ()=>{println("Expect to see this")}, Text("Simple Link"))
    
  def continueButton(in: NodeSeq): NodeSeq = {
   
    def button = SHtml.link("/static/", ()=>{println("HAPPY HAPPY JOY")}, Text("Continue..."))
    
    WiringUI.toNode(in, canContinue, JqWiringSupport.fade) {
      (b,ns) => b match {
        case true => button
        case false => Nil
      }
    }
  
  } 

}

