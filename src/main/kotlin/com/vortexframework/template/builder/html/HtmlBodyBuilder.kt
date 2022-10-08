package com.vortexframework.template.builder.html

import com.vortexframework.template.hashMapOfIgnoreNulls

class HtmlBodyBuilder: HtmlTemplateBuilder() {
    fun h1(classes: String? = null, id: String? = null, attributes: HashMap<String, String> = HashMap(),
           init: HtmlBodyBuilder.() -> Unit) = addTagWithBody(HtmlBodyBuilder(), init, "h1",
        attributes = hashMapOfIgnoreNulls(
            "class" to classes,
            "id" to id,
            *attributes.toList().toTypedArray()
        ))

    fun h1(text: String, classes: String? = null, id: String? = null, attributes: HashMap<String, String> = HashMap()) {
        h1(classes, id, attributes) {
            this += text
        }
    }

    fun a(classes: String? = null, id: String? = null, attributes: HashMap<String, String> = HashMap(),
          href: String? = null, init: HtmlBodyBuilder.() -> Unit) = addTagWithBody(HtmlBodyBuilder(), init, "a",
        attributes = hashMapOfIgnoreNulls(
            "class" to classes,
            "id" to id,
            "href" to href,
            *attributes.toList().toTypedArray()
        ))

    fun a(text: String, classes: String? = null, id: String? = null, attributes: HashMap<String, String> = HashMap(),
          href: String?) {
        a(classes, id, attributes, href=href) {
            this += text
        }
    }

    fun p(classes: String? = null, id: String? = null, attributes: HashMap<String, String> = HashMap(),
          init: HtmlBodyBuilder.() -> Unit) = addTagWithBody(HtmlBodyBuilder(), init, "p",
        attributes = hashMapOfIgnoreNulls(
            "class" to classes,
            "id" to id,
            *attributes.toList().toTypedArray()
        ))

    fun p(text: String, classes: String? = null, id: String? = null, attributes: HashMap<String, String> = HashMap()) {
        p(classes, id, attributes) {
            this += text
        }
    }
}