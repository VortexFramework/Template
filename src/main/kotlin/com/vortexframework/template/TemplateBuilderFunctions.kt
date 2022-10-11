package com.vortexframework.template

import com.vortexframework.template.builder.html.HtmlTagBuilder
import com.vortexframework.template.builder.html.HtmlTemplateBuilder

fun htmlTemplate(init: HtmlTagBuilder.() -> Unit): HtmlTemplateBuilder {
    val base = HtmlTemplateBuilder()
    base.doctype("html")
    base.html(init)

    return base
}

// To be moved to common library in future

fun <K, V> hashMapOfIgnoreNulls(vararg pairs: Pair<K, V?>): HashMap<K, V> {
    val map = HashMap<K, V>()
    for (pair in pairs) {
        if (pair.second != null) {
            map[pair.first] = pair.second!!
        }
    }
    return map
}