import scala.io.Source
import java.io.PrintWriter
import java.io.File
import scala.collection.mutable.StringBuilder

object PreProc {
    def main(args: Array[String]) {
    
    val inputfile = "wikidump.small"
    val outputfile = new PrintWriter(new File("WikiPerLine"))
    var a_output_line = new StringBuilder
    
    val beg_page = "<page>".r
    val end_page = "</page>".r
    var found = false
    var count = 0
    
    // write your code to extract content in every <page> …. </page>
    // write each of that into one line in your output file
    for (inputline <- Source.fromFile(inputfile).getLines) {
        if(found) {
            outputfile.write(inputline)
        }
        for(m <-beg_page.findAllIn(inputline)) {
            outputfile.write(inputline)
            found = true
            count += 1
        }
        for(m<-end_page.findAllIn(inputline)) {
            found = false
            outputfile.println();
        }
    }
    outputfile.close
    println(count)
    }
}
