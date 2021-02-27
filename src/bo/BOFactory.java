package bo;

import bo.impl.*;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){

    }

    public static BOFactory getInstance(){
        if(boFactory==null){
            boFactory=new BOFactory();
        }
        return boFactory;
    }

    public enum BOTypes{
        Section,Return,Quantity,Publisher,Member,Issue,Fine,BookFee,Book,Author,AddBooks;
    }
    public SuperBO getBo(BOTypes types){
        switch (types){
            case Section:
                return new SectionBOImpl();
            case Return:
                return new ReturnBOImpl();
            case Quantity:
                return new QuantityBOImpl();
            case Publisher:
                return new PublisherBOImpl();
            case Member:
                return new MemberBOImpl();
            case Issue:
                return new IssueBOImpl();
            case Fine:
                return new FineBOImpl();
            case BookFee:
                return new BookFeeBOImpl();
            case Book:
                return new BookBOImpl();
            case Author:
                return new AuthorBOImpl();
            case AddBooks:
                return new AddBooksBOImpl();
            default:
                return null;
        }

    }
}
