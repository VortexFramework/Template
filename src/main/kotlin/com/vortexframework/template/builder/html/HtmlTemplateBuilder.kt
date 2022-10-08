package com.vortexframework.template.builder.html

import com.vortexframework.template.builder.html.element.HtmlTagTemplateElement
import com.vortexframework.template.builder.text.TextTemplateBuilder

open class HtmlTemplateBuilder: TextTemplateBuilder() {
    fun header(init: HtmlHeaderBuilder.() -> Unit) = addTagWithBody(HtmlHeaderBuilder(), init, "header")
    fun body(init: HtmlBodyBuilder.() -> Unit) = addTagWithBody(HtmlBodyBuilder(), init, "body")

    protected fun <T: HtmlTemplateBuilder> addTagWithBody(instance: T, init: T.() -> Unit, tagName: String,
                                                          attributes: HashMap<String, String> = HashMap()) {
        instance.init()
        elements.add(
            HtmlTagTemplateElement(tagName, isSelfClosed = false, isInline = false, childElements = instance.elements,
                attributes = attributes)
        )
    }

    override fun toString(): String {
        return elements.joinToString("") { it.build() }
    }
}