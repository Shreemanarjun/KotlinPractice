import com.gargoylesoftware.htmlunit.Page
import com.gargoylesoftware.htmlunit.WebClient
import com.gargoylesoftware.htmlunit.html.DomElement
import com.gargoylesoftware.htmlunit.html.HtmlAnchor
import com.gargoylesoftware.htmlunit.html.HtmlPage
import com.gargoylesoftware.htmlunit.html.HtmlTable

fun main() {
    java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(java.util.logging.Level.OFF);
    java.util.logging.Logger.getLogger("org.apache.http").setLevel(java.util.logging.Level.OFF);

    var client = WebClient()
    var page = client.getPage<HtmlPage>("https://igitsarang.ac.in/news/2019")
    client.options.isJavaScriptEnabled = false
    client.options.isCssEnabled = false

   var l=page.getElementById("table_notice")

print(page.asXml())
  // l.forEach { println(it.toString()) }
}