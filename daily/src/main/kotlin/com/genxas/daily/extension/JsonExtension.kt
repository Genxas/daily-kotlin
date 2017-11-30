package com.genxas.daily.extension

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.TypeAdapter
import com.google.gson.TypeAdapterFactory
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter

inline fun <reified T> String.toObject(): T {
    GsonBuilder()
            .registerTypeAdapterFactory(NullStringToEmptyAdapterFactory())
            .enableComplexMapKeySerialization()
            .setDateFormat("yyyy-MM-dd'T'hh:mm:ss")
            .create()
            .run {
                return fromJson(this@toObject, T::class.java)
            }
}

inline fun <reified T> String.toObjects(classOf: Class<Array<T>>): MutableList<T> {
    return ArrayList(GsonBuilder()
            .registerTypeAdapterFactory(NullStringToEmptyAdapterFactory())
            .setDateFormat("yyyy-MM-dd'T'hh:mm:ss")
            .create()
            .run {
                fromJson(this@toObjects, classOf)
            }.asList())
}

class NullStringToEmptyAdapterFactory : TypeAdapterFactory {
    override fun <T> create(gson: Gson, type: TypeToken<T>): TypeAdapter<T>? {

        if (type.rawType != String::class.java) {
            return null
        }

        return StringAdapter() as TypeAdapter<T>
    }
}

class StringAdapter : TypeAdapter<String>() {
    override fun read(reader: JsonReader): String {
        if (reader.peek() == JsonToken.NULL) {
            reader.nextNull()

            return ""
        }

        return reader.nextString()
    }

    override fun write(writer: JsonWriter, value: String?) {
        if (value == null) {
            writer.nullValue()
        } else {
            writer.value(value)
        }
    }
}