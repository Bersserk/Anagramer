# First_Project_FM

Description
For example:

Ignored characters are “0123456789” and non alphabetic symbols;

Input: “Foxminded cool 24/7” -> Output: “dednimxoF looc 24/7”

Input: “abcd efgh” -> Output: “dcba hgfe”

Input: “a1bcd efg!h” -> Output: “d1cba hgf!e”


Ignored characters are “xl”;

Input: “Foxminded cool 24/7” -> Output: “dexdnimoF oocl 7/42”

Input: “abcd efgh” -> Output: “dcba hgfe”

Input: “a1bcd efglh” -> Output: “dcb1a hgfle”


Logical

1. ВВодим текст
	а. вручную в edittext1
2. ВВодим фильтр
	а. вручную в edittext2
3. Фильтр применяем к тексту
	3.1. алгоритм фильтрации текста. "отдельный метод"
	3.2. Просматриваем строку посимвольно сравнивая каждый символ с символами из фильтра. Если совпадение, символ оставляем на
	своем месте, если не совпадает, то 
	3.3. фильтруем каждое слово
	3.4. каждое отфильтрованное слово передаем на анаграм обработку "стат метод (по условию) с возвратным значением
4. Каждое возвратное слово передаем на вывод в текствью. 
5. Выводим анаграмму на результат

