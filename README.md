#Help 
A Shtml.link rendered via Wiring doesn't appear to execute the associated function when clicked.

# About the app

Derived from 2.4-M4 lift-basic
Lift 2.4-M4, Mac OS, Java 6, Scala 2.9.0-1

I have two long running tasks, which are shown to the user via a lazy load snippet.

When both snippets complete, a "continue" link is rendered via wiring.

That part works just fine.

The "continue" link has a function attached to it which should println HAPPY HAPPY JOY to the terminal.

For comparison, there is also a "simple link" on the page which is a SHtml.link not produced in Wiring.  When it is clicked it printlns "Expect to se this" to the terminal.


# Actual behaviour

The page shows the two lazy loading snippets, and the link correctly appears under them when the snippets complete. 

Clicking the link does not produced "happy happy joy" output to the terminal.

However, clicking the "simple link" does produce output to the terminal.

# Expected behaviour:

After the lazy snippets load, clicking the "Press me" link should generate the string "Happy happy joy" on the terminal.

# Note

The code is all in index.html and the HelloWorld snippet.





