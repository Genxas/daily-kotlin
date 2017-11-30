# daily-kotlin
Utilities which use in daily life in Kotlin

# JSON extension

Single object

```kotlin
"{\"name\": \"john doe\"}".toObject<User>()
```

Multiple objects

```kotlin
"[{\"name\": \"john doe\"}, {\"name\": \"jane doe\"}]".toObjects(Array<User>::class.java)
```

# Number extension

Show number with comma format

```kotlin
1000.1.thousands() // 1,000.1
```