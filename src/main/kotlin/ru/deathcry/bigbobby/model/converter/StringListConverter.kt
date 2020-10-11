package ru.deathcry.bigbobby.model.converter

import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter
class StringListConverter : AttributeConverter<List<String>, String?> {
    override fun convertToDatabaseColumn(stringList: List<String>): String? {
        if (stringList.isEmpty()) {
            return null
        }
        return stringList.joinToString(SPLIT_CHAR)
    }

    override fun convertToEntityAttribute(string: String?): List<String> {
        return string?.split(SPLIT_CHAR)?.toList() ?: listOf()
    }

    companion object {
        private const val SPLIT_CHAR = ";"
    }
}