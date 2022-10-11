package com.vortexframework.template.builder.html

import com.vortexframework.template.builder.html.element.HtmlTagTemplateElement
import com.vortexframework.template.builder.text.TextTemplateBuilder

open class HtmlTemplateBuilder: TextTemplateBuilder() {
    fun html(init: HtmlTagBuilder.() -> Unit) = addTagWithBody(HtmlTagBuilder(), init, "html")
    fun doctype(doctype: String) = addTagWithoutBody("!DOCTYPE", attributes = hashMapOf(doctype to ""))

    protected fun <T: HtmlTemplateBuilder> addTagWithBody(instance: T, init: T.() -> Unit, tagName: String,
                                                          attributes: HashMap<String, String> = HashMap()) {
        instance.init()
        elements.add(
            HtmlTagTemplateElement(tagName, isSelfClosed = false, isInline = false, childElements = instance.elements,
                attributes = attributes)
        )
    }

    protected fun addTagWithoutBody(tagName: String, attributes: HashMap<String, String> = HashMap()) {
        elements.add(HtmlTagTemplateElement(tagName, isSelfClosed = false, isInline = true, attributes = attributes))
    }

    override fun toString(): String {
        return elements.joinToString("") { it.build() }
    }
}