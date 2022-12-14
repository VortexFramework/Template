import com.vortexframework.template.htmlTemplate
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TestTemplateRendering {
    private fun String.min() = this.split("\n").joinToString("") { it.trimStart() }
    @Test
    fun `Test can render template with no content`() {
        assertEquals("<!DOCTYPE html><html></html>", htmlTemplate{}.toString())
    }

    @Test
    fun `Test can render template with title`() {
        assertEquals("""
            <!DOCTYPE html>
            <html>
                <header>
                    <title>Test</title>
                </header>
            </html>
        """.min(), htmlTemplate {
            header {
                title("Test")
            }
        }.toString())
    }

    @Test
    fun `Test can render template with JS and CSS`() {
        assertEquals("""
            <!DOCTYPE html>
            <html>
                <header>
                    <link rel="stylesheet" href="test.css"/>
                    <link rel="stylesheet" href="foo.css"/>
                    <script src="test.js"></script>
                    <script src="foo.js"></script>
                </header>
            </html>
        """.min(), htmlTemplate {
            header {
                withStyles("test.css", "foo.css")
                withJavascript("test.js", "foo.js")
            }
        }.toString())
    }

    @Test
    fun `Can render basic html page`() {
        assertEquals("""
            <!DOCTYPE html>
            <html>
                <header>
                    <title>This is a test</title>
                </header>
                <body>
                    <h1>Welcome to my website</h1>
                    <p>
                        Built using <a href="https://github.com/VortexFramework/Template">Vortex Template</a>
                    </p>
                </body>
            </html>
        """.min(), htmlTemplate {
            header {
                title("This is a test")
            }
            body {
                h1("Welcome to my website")
                p {
                    this+="Built using "; a("Vortex Template", href="https://github.com/VortexFramework/Template")
                }
            }
        }.toString())
    }

}