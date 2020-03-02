package com.asem.regestration.model.dao.utils;

import java.util.LinkedList;




    public class Queue2 {
        private LinkedList<WraperConnection> items=null;
        private int QmaxSize=0;
        private static Queue2 single=new Queue2(10);
        private Queue2(int max){
            this.items=new LinkedList();
            this.QmaxSize=max;




        }
        public static Queue2 getInstance(){
            return single;
        }

        public void enQueue(WraperConnection valu){
            if(isFully())
                throw new RuntimeException("cannot enQueu");

            items.addLast(valu);

        }
        public WraperConnection deQueue(){
            if(items.isEmpty())
                throw new RuntimeException("cannot deQueue");
            WraperConnection temp=items.getFirst();
            items.removeFirst();
            return temp;
        }
        public boolean isFully(){
            return items.size()==QmaxSize;
        }
        public boolean isEmpty(){
            return items.isEmpty();
        }

        @Override
        public String toString() {
            return items.toString();
        }
    }


