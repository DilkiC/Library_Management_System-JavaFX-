package dao;


import dao.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){

    }

    public static DAOFactory getInstance(){
        if(daoFactory==null){
            daoFactory=new DAOFactory();
        }
        return daoFactory;
    }

    public enum DAOTypes{
        Section,Return,Quantity,Publisher,Member,Issue,Fine,BookFee,Book,Author,AddBooks;
    }
    public SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case Section:
                return new SectionDAOImpl();
            case Return:
                return new ReturnDAOImpl();
            case Quantity:
                return new QuantityDAOImpl();
            case Publisher:
                return new PublisherDAOImpl();
            case Member:
                return new MemberDAOImpl();
            case Issue:
                return new IssueDAOImpl();
            case Fine:
                return new FineDAOImpl();
            case BookFee:
                return new BookFeeDAOImpl();
            case Book:
                return new BookDAOImpl();
            case Author:
                return new AuthorDAOImpl();

            default:
                return null;
        }
    }
}
