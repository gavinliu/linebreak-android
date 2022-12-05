cmake_minimum_required(VERSION 3.18.1)

project("linebreak")

add_library(
        linebreak

        SHARED

        LineBreaker.cpp

        libunibreak/linebreak.c
        libunibreak/linebreakdata.c
        libunibreak/linebreakdef.c
        libunibreak/wordbreak.c
        libunibreak/graphemebreak.c
        libunibreak/emojidef.c
        libunibreak/unibreakbase.c
        libunibreak/unibreakdef.c
        )

target_link_libraries(
        linebreak
)