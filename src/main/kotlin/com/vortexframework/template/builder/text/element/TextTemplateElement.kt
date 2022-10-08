package com.vortexframework.template.builder.text.element

import com.vortexframework.template.TemplateElement

class TextTemplateElement(private val text: String): TemplateElement {
    override fun build(): String {
        return text
    }
}