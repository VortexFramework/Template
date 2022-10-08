package com.vortexframework.template

import com.vortexframework.template.builder.html.HtmlTemplateBuilder

fun htmlTemplate(init: HtmlTemplateBuilder.() -> Unit): HtmlTemplateBuilder {
    val template = HtmlTemplateBuilder()
    template.init()
    return template
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