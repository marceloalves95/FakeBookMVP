package br.com.fakebookmvp.domain.model

val dummyFakeBookData = FakeBookData(
    id = 1,
    title = "RABBIT' engraved.",
    author = "Marlon Medhurst",
    genre = "Dolorum",
    description = "I've often seen them at dinn--' she checked herself hastily. 'I don't see,' said the Hatter. 'Does YOUR watch tell you how it was out of sight before the end of the country is, you see, as they used.",
    isbn = "9798613565887",
    image = "http://placeimg.com/480/640/any",
    published = "2008-07-02",
    publisher = "Nihil Quas"
)

val dummyFakeBook = FakeBook(
    status = "OK",
    code = 200,
    total = 1,
    data = listOf(dummyFakeBookData)
)