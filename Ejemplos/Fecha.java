public class Fecha
{
    private int dia;
    private int mes;
    private int año;

    private int fechaToDias()
    {
        int dias = 0;
        int mult = 0;
        for(int iCont = 0; iCont<año; iCont++)
        {   
            mult = iCont % 4;
            if(mult == 0)
            {
                dias = dias + 366;
            }
            else
            {
                dias = dias + 365;
            }
        }
        for(int iCont = 1; iCont<mes; iCont++)
        {
            switch(iCont)
            {
                case 1:
                dias = dias + 31;
                break;
                case 2:
                if((año % 4) == 0)
                {
                    dias = dias + 29;
                }
                else
                {
                    dias = dias + 28;
                }
                break;
                case 3:
                dias = dias + 31;
                break;
                case 4:
                dias = dias + 30;
                break;
                case 5:
                dias = dias + 31;
                break;
                case 6:
                dias = dias + 30;
                break;
                case 7:
                dias = dias + 31;
                break;
                case 8:
                dias = dias + 31;
                break;
                case 9:
                dias = dias + 30;
                break;
                case 10:
                dias = dias + 31;
                break;
                case 11:
                dias = dias + 30;
                break;
                case 12:
                dias = dias + 31;
                break;
                default:
                System.out.println("ERROR");
            }
        }
        dias = dias + dia;
        return dias;
    }

    private void diasToFecha(int i)
    {
        dia = 0;
        mes = 0;
        año = 0;
        for(int iCont = 0; i >= 366; iCont++)
        {
            if((iCont % 4) == 0)
            {
                año = año + 1;
                i = i - 366;
            }
            else
            {
                año = año + 1;
                i = i - 365;
            }
        }
        for(int iCont = 1; i >= 31; iCont++)
        {
            switch(iCont)
            {
                case 1:
                i = i - 31;
                mes = mes + 1;
                break;
                case 2:
                if((año % 4) == 0)
                {
                    i = i - 29;
                    mes = mes + 1;
                }
                else
                {
                    i = i - 28;
                    mes = mes + 1;
                }
                break;
                case 3:
                i = i - 31;
                mes = mes + 1;
                break;
                case 4:
                i = i - 30;
                mes = mes + 1;
                break;
                case 5:
                i = i - 31;
                mes = mes + 1;
                break;
                case 6:
                i = i - 30;
                mes = mes + 1;
                break;
                case 7:
                i = i - 31;
                mes = mes + 1;
                break;
                case 8:
                i = i - 31;
                mes = mes + 1;
                break;
                case 9:
                i = i - 30;
                mes = mes + 1;
                break;
                case 10:
                i = i - 31;
                mes = mes + 1;
                break;
                case 11:
                i = i - 30;
                mes = mes + 1;
                break;
                case 12:
                i = i - 31;
                mes = mes + 1;
                break;
                default:
                System.out.println("ERROR");
            }
        }
        dia = i;
    }
    public void addDias(int d)
    {
        int sum = fechaToDias() + d;
        diasToFecha(sum);
    }

    public int difDias(Fecha f1, Fecha f2)
    {
        int aux1 = f1.fechaToDias();
        int aux2 = f2.fechaToDias();
        int dif = aux2 - aux1;
        return dif;
    }

    public Fecha(String s)  //Constructor para poder analizar fechas ingresadas en la forma dd/mm/aaaa. Sobrecarga
    {
        int pos1 = s.indexOf('/');      //Buscar primer aparicion del caracter
        int pos2 = s.lastIndexOf('/');  //Buscar ultima aparicion del caracter

        String sDia = s.substring(0,pos1);  //Recortar String s
        dia = Integer.parseInt(sDia);

        String sMes = s.substring(pos1+1,pos2);
        mes = Integer.parseInt(sMes);

        String sAño = s.substring(pos2+1);
        año = Integer.parseInt(sAño);
    }

    public Fecha(int d, int m, int a)
    {
        dia = d;
        mes = m;
        año = a;
    }

    public Fecha()
    {}

    public int getDia()
    {
        return dia;
    }

    public void setDia(int dia)
    {
        this.dia = dia;
    }

    public int getMes()
    {
        return mes;
    }

    public void setMes(int mes)
    {
        this.mes = mes;
    }
    public int getAño()
    {
        return año;
    }

    public void setAño(int año)
    {
        this.año = año;
    }

    public String toString()
    {
        return dia + "/" + mes + "/" + año;
    }

    public boolean equals(Object o)
    {
        Fecha otra = (Fecha)o;
        return (dia == otra.dia) && (mes == otra.mes) && (año == otra.año);
    }
}