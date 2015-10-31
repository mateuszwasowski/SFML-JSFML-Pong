#include "../include/UtilText.h"

UtilText::UtilText( std::string str)
{

    if (!font.loadFromFile("arial.ttf"))
    {
        // error...
    }

    Tekst.setFont(font);
    Tekst.setString(str);
}
void UtilText::setText(int a, int b, int c, sf::Color color )
{
    Tekst.setPosition(a,b);
    Tekst.setCharacterSize(c);
    Tekst.setColor(color);

}
void UtilText::setString(std::string s)
{
    Tekst.setString(s);
}


sf::Text UtilText::getObject()
{

    return Tekst;

}

