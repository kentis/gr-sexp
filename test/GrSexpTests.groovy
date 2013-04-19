import static org.junit.Assert.assertThat
import static org.hamcrest.CoreMatchers.*
import static org.junit.matchers.JUnitMatchers.*
import static org.junit.Assert.*
import org.junit.Test
import org.k1s.GrSexp.GrSexp

class GrSexpTests {


    @Test void testSexp() {
	def sexp = "(eq a b)"
	GrSexp a = new GrSexp()
	def parsed = a.parse(sexp)
	
	println "$parsed"
	assertThat parsed, is(not(null))
	assertThat parsed[0].toString(), is("<eq>")
	assertThat parsed[1].toString(), is("<a>")
	assertThat parsed[2].toString(), is("<b>")
    }

   @Test void testNestedSexp() {
        def sexp = "(or (eq a b) (eq a c) )"
        GrSexp a = new GrSexp()
        def parsed = a.parse(sexp)

        println "$parsed"
        assertThat parsed, is(not(null))
	assertThat parsed[0].toString(), is("<or>")
	assertThat parsed[1][0].toString(), is("<eq>")
	assertThat parsed[1][2].toString(), is("<b>")
    }

}
