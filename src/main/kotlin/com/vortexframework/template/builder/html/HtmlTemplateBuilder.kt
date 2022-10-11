package com.vortexframework.template.builder.html

import com.vortexframework.template.builder.html.element.HtmlTagTemplateElement
import com.vortexframework.template.builder.text.TextTemplateBuilder

open class HtmlTemplateBuilder: TextTemplateBuilder() {
    fun html(init: HtmlTagBuilder.() -> Unit) = addTagWithBody(HtmlTagBuilder(), init, "html")

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