import java.io.*;

public class Parser {
        private Lexer lex;
        private BufferedReader pbr;
        private Token look;

        public Parser(Lexer l, BufferedReader br) 
        {
                lex = l;
                pbr = br;
                move();
        }

        void move() 
        {
                look = lex.lexical_scan(pbr);
                System.err.println("token = " + look);
        }

        void error(String s) 
        {
	        throw new Error("near line " + lex.line + ": " + s);
        }

        void match(int t) 
        {
	        if (look.tag == t)
                {
	                if (look.tag != Tag.EOF) move();
	        } else error("syntax error");
        }

        public void start() 
        {
                if (look.tag == Tag.NUM || look.tag == '(')
                {
                        expr();
                        match(Tag.EOF);
                }
                else if(look.tag == Tag.EOF)
                {
                        match(Tag.EOF);
	                System.out.println("Nessun espressione");
                }
                else error("l'espressione non puo iniziare con " + look);
        }

        private void expr() 
        {
                if(look.tag == '(' || look.tag == Tag.NUM)
                {
                        term();
                        exprp();
                }
                else error("Era atteso '(' o NUM");
        }

        private void exprp() 
        {
                if(look.tag == '+' || look.tag == '-')
                {
	                switch (look.tag)
                        {
                                case '+':
                                match('+');
                                term();
                                exprp();
                                break;
                                        
                                case '-':
                                match('-');
                                term();
                                exprp();
                                break;
                        }
                }
                else if(look.tag == Tag.EOF || look.tag == ')'){}
                else error("errore in exprp");
        }

        private void term() 
        {
                if(look.tag == '(' || look.tag == Tag.NUM)
                {
                        fact();
                        termp();
                }
                else error("errore in term");
        }

        private void termp() 
        {
                if(look.tag == '*' || look.tag == '/')
                {
                        switch (look.tag)
                        {
                                case '*':
                                match('*');
                                fact();
                                termp();
                                break;
                                        
                                case '/':
                                match('/');
                                fact();
                                termp();
                                break;
	                }
                }
                else if(look.tag == Tag.EOF || look.tag == ')' || look.tag == '+' || look.tag == '-'){}
                else error("Errore in termp");
        }

        private void fact() 
        {
                if(look.tag == Tag.NUM)
                {
                        match(Tag.NUM);
                }
                else if(look.tag == '(')
                {
                        match('(');
                        expr();
                        match(')');
                }
                else error("Errore in fact");
        }

        public static void main(String[] args) 
        {
                Lexer lex = new Lexer();
                String path = "Prova.txt"; // il percorso del file da leggere
                try {
                        BufferedReader br = new BufferedReader(new FileReader(path));
                        Parser parser = new Parser(lex, br);
                        parser.start();
                        System.out.println("Input OK");
                        br.close();
                } catch (IOException e) 
                {
                        e.printStackTrace();
                }
        }
}
