# realm-delete-bug
Demonstrating a potential bug with `deleteAll()` in Realm. The expectation is that `deleteAll` will only delete `RealmObject`s associated with its `Realm`, but it seems to delete objects across `Realm` and `@RealmModule` boundaries. This leads to a runtime exception since `deleteAll()` is trying to access `RealmObject`s in a difference module.
