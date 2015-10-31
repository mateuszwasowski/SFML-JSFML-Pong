#include <SFML/Graphics.hpp>
#include "include/Rectangle.h"
#include "include/Paddle.h"
#include "include/Ball.h"
#include "include/UtilText.h"
#include "include/Gameslot.h"
#include <string>
#include <sstream>
#include <math.h>
#include <iostream>

#define SSTR( x ) dynamic_cast< std::ostringstream & >( ( std::ostringstream() << std::dec << x ) ).str()

const int TOP_RECT_WIDTH = 800;
const int TOP_RECT_HEIGHT = 2;
sf::Color TOP_RECT_COLOR = sf::Color::White;

const int BOTTOM_RECT_WIDTH = 800;
const int BOTTOM_RECT_HEIGHT = 2;
sf::Color BOTTOM_RECT_COLOR = sf::Color::White;

const int LEFT_RECT_WIDTH = 2;
const int LEFT_RECT_HEIGHT = 600;
sf::Color LEFT_RECT_COLOR = sf::Color::White;

const int RIGHT_RECT_WIDTH = 2;
const int RIGHT_RECT_HEIGHT = 600;
sf::Color RIGHT_RECT_COLOR = sf::Color::White;

const int DIVIDER_WIDTH = 5;
const int DIVIDER_HEIGHT = 500;
sf::Color DIVIDER_COLOR = sf::Color(255,255,255,130);

const int PLAYER_WIDTH = 10;
const int PLAYER_HEIGHT = 80;

sf::Color PLAYER_1_COLOR = sf::Color::White;
sf::Color PLAYER_2_COLOR = sf::Color::White;

const float BALL_RADIUS = 5.0f;
sf::Color BALL_COLOR = sf::Color::White;
sf::Vector2f DEFAULT_POSITION = sf::Vector2f(398 , 300);


sf::Clock Clock;
sf::Time currentTime;

int p1score=0 , p2score=0;

int main()
{

    std::string temp;

    Gameslot slot1("game_slot1");
    Gameslot slot2("game_slot2");


    Ball ball (BALL_RADIUS,BALL_COLOR);
    ball.Init(DEFAULT_POSITION);

    bool ballMoving = false;
    bool ballStopped = true;

    int select = 1;

    int ballRandomDirection = 1;

    sf::RenderWindow window(sf::VideoMode(800, 600), "Ultimate Pong 2000");

    Paddle player2 (PLAYER_WIDTH,PLAYER_HEIGHT,PLAYER_2_COLOR);
    player2.setPosition(sf::Vector2f(780, 260));
    Paddle player1(PLAYER_WIDTH,PLAYER_HEIGHT,PLAYER_1_COLOR);
    player1.setPosition(sf::Vector2f(10, 260));


    //////////////SELECTION SCREEN///////////////////////

    Rectangle left1(10,160,sf::Color::Red);
    left1.setPosition(sf::Vector2f(100, 100));
    Rectangle right1(10,160,sf::Color::Red);
    right1.setPosition(sf::Vector2f(700, 100));

    Rectangle top1(600,10,sf::Color::Red);
    top1.setPosition(sf::Vector2f(100, 100));
    Rectangle bottom1(600,10,sf::Color::Red);
    bottom1.setPosition(sf::Vector2f(100, 250));

    Rectangle left2(10,160,LEFT_RECT_COLOR);
    left2.setPosition(sf::Vector2f(100, 300));
    Rectangle right2(10,160,RIGHT_RECT_COLOR);
    right2.setPosition(sf::Vector2f(700, 300));

    Rectangle top2(600,10,TOP_RECT_COLOR);
    top2.setPosition(sf::Vector2f(100, 300));
    Rectangle bottom2(600,10,BOTTOM_RECT_COLOR);
    bottom2.setPosition(sf::Vector2f(100, 450));

    UtilText select1("GAME SLOT 1");
    select1.setText(170,130,70,sf::Color::White);
    UtilText select2("GAME SLOT 2");
    select2.setText(170,330,70,sf::Color::White);
    UtilText pressnum("PRESS 1 OR 2 TO SELECT GAME SLOT");
    pressnum.setText(130,500,30,sf::Color::White);
    UtilText pressspace("PRESS SPACE TO CONFIRM");
    pressspace.setText(200,550,30,sf::Color::White);

    Rectangle leftRect(LEFT_RECT_WIDTH,LEFT_RECT_HEIGHT,LEFT_RECT_COLOR);
    leftRect.setPosition(sf::Vector2f(0, 0));
    Rectangle rightRect(RIGHT_RECT_WIDTH,RIGHT_RECT_HEIGHT,RIGHT_RECT_COLOR);
    rightRect.setPosition(sf::Vector2f(798, 0));

    Rectangle topRect(TOP_RECT_WIDTH,TOP_RECT_HEIGHT,TOP_RECT_COLOR);
    topRect.setPosition(sf::Vector2f(0, 0));
    Rectangle bottomRect(BOTTOM_RECT_WIDTH,BOTTOM_RECT_HEIGHT,BOTTOM_RECT_COLOR);
    bottomRect.setPosition(sf::Vector2f(0, 598));

    Rectangle podzial(DIVIDER_WIDTH,DIVIDER_HEIGHT,DIVIDER_COLOR);
    podzial.setPosition(sf::Vector2f(400, 50));


    UtilText text7("YOU LOST!");
    text7.setText(200,400,80,sf::Color::White);
    UtilText text8("YOU WON!");
    text8.setText(200,400,80,sf::Color::White);

    UtilText text4("PRESS ENTER TO INSERT COIN");
    text4.setText(170,400,30,sf::Color::White);
    UtilText text5("ULTIMATE");
    text5.setText(200,180,80,sf::Color::White);
    text5.getObject().setStyle(sf::Text::Bold);
    UtilText text6("PONG 2000");
    text6.setText(230,280,60,sf::Color::White);
    text6.getObject().setStyle(sf::Text::Bold);

    UtilText text1(SSTR(p1score));
    text1.setText(300,20,50, sf::Color::White);
    UtilText text2(SSTR(p2score));
    text2.setText(480,20,50, sf::Color::White);

    UtilText text3("");
    text3.setText(20,20,50,sf::Color(255,255,255,130));

    bool start = false;
    slot1.open();
    slot2.open();
    while (window.isOpen())
    {
        while (start == false && window.isOpen())
        {

            if(sf::Keyboard::isKeyPressed(sf::Keyboard::Return))
            {
                start = true;
                break;
            }

            sf::Event event;
            while (window.pollEvent(event))
            {
                if (event.type == sf::Event::Closed)
                    window.close();
            }


            window.clear();
            window.draw(text4.getObject());
            window.draw(text5.getObject());
            window.draw(text6.getObject());
            window.display();


        }
        if(sf::Keyboard::isKeyPressed(sf::Keyboard::Num1))
        {
            left1.setColor(sf::Color::Red);
            right1.setColor(sf::Color::Red);
            bottom1.setColor(sf::Color::Red);
            top1.setColor(sf::Color::Red);
            left2.setColor(sf::Color::White);
            right2.setColor(sf::Color::White);
            bottom2.setColor(sf::Color::White);
            top2.setColor(sf::Color::White);
            select = 1;
        }
        if(sf::Keyboard::isKeyPressed(sf::Keyboard::Num2))
        {
            left1.setColor(sf::Color::White);
            right1.setColor(sf::Color::White);
            bottom1.setColor(sf::Color::White);
            top1.setColor(sf::Color::White);
            left2.setColor(sf::Color::Red);
            right2.setColor(sf::Color::Red);
            bottom2.setColor(sf::Color::Red);
            top2.setColor(sf::Color::Red);
            select = 2;

        }


        if(sf::Keyboard::isKeyPressed(sf::Keyboard::Space)){
            if(select == 1)
            slot2.close();
            else{
            slot1.close();
            }
            break;

        }



        window.clear();
        window.draw(left1.getObject());
        window.draw(right1.getObject());
        window.draw(bottom1.getObject());
        window.draw(top1.getObject());
        window.draw(left2.getObject());
        window.draw(right2.getObject());
        window.draw(bottom2.getObject());
        window.draw(top2.getObject());
        window.draw(select1.getObject());
        window.draw(select2.getObject());
        window.draw(pressnum.getObject());
        window.draw(pressspace.getObject());
        window.display();


        sf::Event event;
        while (window.pollEvent(event))
        {
            if (event.type == sf::Event::Closed)
                window.close();

        }
    }


// MAIN GAME ////////////////////////////////////////////////////

    while (window.isOpen())
    {


        currentTime = Clock.getElapsedTime();
        text3.setString("time : " + SSTR(floor(currentTime.asSeconds())));

        if(sf::Keyboard::isKeyPressed(sf::Keyboard::Up))
            player1.goUp();

        if(sf::Keyboard::isKeyPressed(sf::Keyboard::Down))
            player1.goDown();



        if(sf::Keyboard::isKeyPressed(sf::Keyboard::Space))
            if(!ballMoving && ballStopped)
            {
                ballMoving = true;
                ballStopped = false;
            }

        if(topRect.touches(player1.getObject()))
            player1.setPosition(sf::Vector2f(player1.getObject().getPosition().x, topRect.getObject().getPosition().y + 2));

        if(bottomRect.touches(player1.getObject()))
            player1.setPosition(sf::Vector2f(player1.getObject().getPosition().x, bottomRect.getObject().getPosition().y-80));

        if(topRect.touches(player2.getObject()))
            player2.setPosition(sf::Vector2f(player2.getPosition().x, topRect.getObject().getPosition().y + 2));

        if(bottomRect.touches(player2.getObject()))
            player2.setPosition(sf::Vector2f(player2.getPosition().x, bottomRect.getObject().getPosition().y-80));


        sf::Event event;
        while (window.pollEvent(event))
        {
            if (event.type == sf::Event::Closed)
                window.close();

        }
//BALL KOLIZJA

        if(ball.touches(bottomRect.getObject()))
            ball.deflectY();

        if(ball.touches(topRect.getObject()))
            ball.deflectY();

        if(ball.touches(player1.getObject()))
        {
            ball.deflectX();
            ball.accelerate(player1);
        }

        if(ball.touches((player2.getObject())))
        {
            ball.deflectX();
            ball.accelerate(player2);
        }


        if(ball.touches(leftRect.getObject()))
        {
            p2score++;
            text2.setString(SSTR(p2score));
            ball.Init(DEFAULT_POSITION);
            player1.setPosition(sf::Vector2f(10, 260));
            player2.setPosition(sf::Vector2f(780, 260));
            ballMoving = false;
            ballStopped = true;
            ball.resetSpeed(ballRandomDirection * (-1));
        }

        if(ball.touches(rightRect.getObject()))
        {
            p1score++;
            text1.setString(SSTR(p1score));
            ball.Init(DEFAULT_POSITION);
            player1.setPosition(sf::Vector2f(10, 260));
            player2.setPosition(sf::Vector2f(780, 260));
            ballMoving = false;
            ballStopped = true;
            ball.resetSpeed(ballRandomDirection * (-1));
        }

        if(ballMoving && !ballStopped)
            ball.move();


//  AI PLAYER2

        if (ball.getBallPosition().y < player2.getPosition().y)
            player2.goUp();

        if(ball.getBallPosition().y +  2 * ball.getBallRadius() >
                player2.getPosition().y + player2.getObject().getSize().y)
            player2.goDown();

        window.clear();
        window.draw(text1.getObject());
        window.draw(text2.getObject());
        window.draw(text3.getObject());
        window.draw(ball.getObject());
        window.draw(podzial.getObject());
        window.draw(topRect.getObject());
        window.draw(leftRect.getObject());
        window.draw(rightRect.getObject());
        window.draw(bottomRect.getObject());
        window.draw(player1.getObject());
        window.draw(player2.getObject());
        window.display();

        if (p1score == 10)
        {

            break;
        }
        else if (p2score == 10)
        {

            break;
        }
    }

    if (select == 1)
        slot1.save( SSTR(floor(currentTime.asSeconds())),p1score,p2score);
    else
        slot2.save(SSTR(floor(currentTime.asSeconds())),p1score,p2score);

    if(p1score == 10)
    {

        while (window.isOpen())
        {

            window.clear();
            window.draw(text8.getObject());
            window.display();

            sf::Event event;
            while (window.pollEvent(event))
            {
                if (event.type == sf::Event::Closed)
                    window.close();

            }
        }


    }
    else if (p2score == 10)
    {


        while (window.isOpen())
        {

            window.clear();
            window.draw(text7.getObject());
            window.display();


            sf::Event event;
            while (window.pollEvent(event))
            {
                if (event.type == sf::Event::Closed)
                    window.close();

            }
        }
    }
    slot1.close();
    slot2.close();
    return 0;
}
