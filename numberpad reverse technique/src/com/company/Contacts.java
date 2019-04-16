package com.company;

import java.awt.*;

class Contacts extends Frame {
    String actualName;
    String numericalName;
    Button b[],benter,bagain;
    TextField t;
    List l;
    public Font myfont;
    Panel p;
   Contacts(){
       super("Contacts");
       p=new Panel();
       bagain=new Button("again");
       bagain.setFont(new Font("",Font.ITALIC,15));
       benter=new Button("click here");
       benter.setFont(new Font("",Font.ITALIC,15));
       p.setLayout(new GridLayout(4,3,1,1));
       l=new List();
       b=new Button[10];
       myfont=new Font(" ",Font.BOLD,35);
       t=new TextField(10);
       for(int i=0;i<10;i++){
                   b[i]=new Button();
                   b[i].setLabel(""+(i+1));
                   p.add(b[i]);
                   b[i].setFont(myfont);
                   b[i].setBackground(Color.CYAN);
                   if(i==9){
                       b[9].setLabel("0");
                       p.add(b[9],9);

                   }

       }
        add(t);
       add(benter);
       add(bagain);
       bagain.setBounds(840,200,50,50);
       benter.setBounds(730,200,100,50);
        t.setBounds(500,200,200,30);
        l.setBounds(650,300,300,300);
        l.setVisible(false);
       p.setLayout(new GridLayout(4,3,1,1));
       p.setBounds(300,300,300,300);
       p.setVisible(true);
       add(p);
       add(l);

       setLayout(null);
       setSize(1000,1000);
       setVisible(true);
   }

    Contacts(String aname){
        this.actualName = aname;
        numericalName = "";
    }
}
