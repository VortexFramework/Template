package com.vortexframework.template.builder

import com.vortexframework.template.TemplateElement

abstract class TemplateBuilder {
    protected val elements = ArrayList<TemplateElement>()

    override fun toString(): String {
        return elements.joinToString("\n") { it.build() }
    }
}