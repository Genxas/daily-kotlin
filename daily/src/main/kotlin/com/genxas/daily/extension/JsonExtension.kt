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
    return GsonBuilder()
            .registerTypeAdapterFactory(NullStringToEmptyAdapterFactory())
            .enableComplexMapKeySerialization()
            .setDateFormat("yyyy-MM-dd'T'hh:mm:ss")
            .create()
            .fromJson(this@toObject, T::class.java)
}

inline fun <reified T> String.toObjects(): MutableList<T> {
    return GsonBuilder()
            .registerTypeAdapterFactory(NullStringToEmptyAdapterFactory())
            .setDateFormat("yyyy-MM-dd'T'hh:mm:ss")
            .create()
            .fromJson(this@toObjects, TypeToken.getParameterized(ArrayList::class.java, T::class.java).type)
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