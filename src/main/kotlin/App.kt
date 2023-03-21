import com.ibm.icu.text.MessageFormat
import com.ibm.icu.text.NumberFormat
import java.util.*

// about formatter usage - https://unicode-org.github.io/icu/userguide/format_parse/messages/
// plural rules - https://cldr.unicode.org/index/cldr-spec/plural-rules
// plural rules chart for languages - https://unicode-org.github.io/cldr-staging/charts/37/supplemental/language_plural_rules.html
// online editor - https://format-message.github.io/icu-message-format-for-translators/editor.html

//add dependency "com.ibm.icu:icu4j:72.1"
//create ResourceBundle
//getBundle
//MessageFormat

//Kupiłeś i zapłaciłeś: Czapka od H&M
//Kupiłaś: 5 produktów w tym Czapka od H&M
//Kupiono i zapłacono: 2 produkty w tym Czapka od 3 sprzedawców

fun main() {
    println(translate("header.boughtAndPaid", Locale("pl_PL"), listOf(3, "Czapka", 2, "H&M", "female", true)))
    println(translate("header.boughtAndPaid", Locale("pl_PL"), listOf(1, "Czapka", 2, "H&M", "male", false)))
    println(translate("header.boughtAndPaid", Locale("pl_PL"), listOf(3, "Czapka", 1, "H&M", "female", true)))
}

private fun translate(key: String, locale: Locale, parameters: List<Any> = listOf()): String? {
    val bundle = ResourceBundle.getBundle("header", locale)
    return MessageFormat(bundle.getString(key)).format(parameters.toTypedArray())
}
