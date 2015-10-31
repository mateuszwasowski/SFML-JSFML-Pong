#include "../include/Gameslot.h"

Gameslot::Gameslot(std::string n)
{
name = n + ".txt";

}

void Gameslot::open(){

account.open( name.c_str(), std::ios::in | std::ios::out );

}

void Gameslot::save(std::string time, int p1scor , int p2scor){

account.seekp( 0, std::ios_base::end );

account << "Time: " << time << " | Score : " << p1scor << " : "<< p2scor <<std::endl;

}

void Gameslot::close(){

account.close();

}
