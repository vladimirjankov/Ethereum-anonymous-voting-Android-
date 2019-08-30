package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.admin.methods.response.NewAccountIdentifier;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import java.math.BigDecimal;
import java.math.BigInteger;

public class MainActivity extends AppCompatActivity {

    private String privateKey = "1935d851e0e4b4ac0d59dd88228dc80beee2e75216113b3db6887a72e474059f";
    private final static BigInteger GAS_LIMIT = BigInteger.valueOf(6721975L);
    private final static BigInteger GAS_PRICE = BigInteger.valueOf(20000000000L);

    private final static String RECIPIENT = "0xfe33EF8A19B06c4b4AfB86b6F8EC9EA1fBa48E77";
    private Upitnik upitnik = null;
    public String pobednik = "Niko jos nije pobedio";
    public String contractAddress = "";
    private String standard_voting_address[]= {"0xC57dd30fa02DBF90dC168243f58183c483E6f836",
            "0xfe33EF8A19B06c4b4AfB86b6F8EC9EA1fBa48E77"
            ,"0xD36E0Aa821931a1aB0A930ACa9e95CE07bDE5a30",
            "0x465d6764319E00f3a14Bd4C0Ea0d7E4B85D8b4f0",
            "0x16E0E7DD1a6E0BE91F92972447c80942597CE6Ea"};
    public Tuple2<String, BigInteger> pair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // textview
        TextView txtView = (TextView) findViewById(R.id.txtView);
        TextView txtIscitanoPitanje = (TextView) findViewById(R.id.txtIscitanoPitanje);

        //edittextovi
        EditText edtPitanje = (EditText) findViewById(R.id.edtPitanje);
        EditText edtOdg1 = (EditText) findViewById(R.id.edtOdg1);
        EditText edtOdg2 = (EditText) findViewById(R.id.edtOdg2);
        EditText edtOdg3 = (EditText) findViewById(R.id.edtOdg3);
        EditText edtOdg4 = (EditText) findViewById(R.id.edtOdg4);
        EditText edtNewAddress = (EditText) findViewById(R.id.edtNewAddress);
        EditText edtContractAddress = (EditText) findViewById(R.id.edtContractAddress);
        EditText edtPrivateKey = (EditText) findViewById(R.id.edtPrivateKey);


        Button btnPitaj = (Button) findViewById(R.id.btnPitaj);
        Button btnClick = (Button) findViewById(R.id.btnTransfer);
        Button btnAddAddress = (Button) findViewById(R.id.btnAddAddress);
        Button btnZavrsiUpitnik = (Button) findViewById(R.id.btnZavrsiUpitnik);
        Button btnOdg1 = (Button) findViewById(R.id.btnOdg1);
        Button btnOdg2 = (Button) findViewById(R.id.btnOdg2);
        Button btnOdg3 = (Button) findViewById(R.id.btnOdg3);
        Button btnOdg4 = (Button) findViewById(R.id.btnOdg4);
        Button btnLoadContract = (Button) findViewById(R.id.btnLoadContractFromAddress);
        Button btnPrivateKey = (Button) findViewById(R.id.btnPrivateKey);


        Web3j web3j = Web3j.build(new HttpService("https://ropsten.infura.io/v3/72d5d7cec5154a82b2226b781e570e4a"));
        Credentials crd = null;
        try {
            Web3ClientVersion clientVersion = web3j.web3ClientVersion().sendAsync().get();
            txtView.setText("Version" + clientVersion.getWeb3ClientVersion());
             crd = getCredentialsFromPrivateKey(privateKey);
        }catch (Exception e){
            txtView.setText("Ne radi");
        }
        TransactionManager transactionManager = new RawTransactionManager( web3j, crd);
        Transfer transfer = new Transfer(web3j, transactionManager);

        btnLoadContract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            upitnik = loadContract(edtContractAddress.getText().toString(), web3j, getCredentialsFromPrivateKey(privateKey));
                            String odg = upitnik.pitanje().send();
                            txtIscitanoPitanje.setText(odg);
                            pair = upitnik.Odgovori(0).send();
                            btnOdg1.setText(pair.getValue1());
                            pair = upitnik.Odgovori(1).send();
                            btnOdg2.setText(pair.getValue1());
                            pair = upitnik.Odgovori(2).send();
                            btnOdg3.setText(pair.getValue1());
                            pair = upitnik.Odgovori(3).send();
                            btnOdg4.setText(pair.getValue1());

                        }catch(Exception e){

                        }
                    }
                });
                thread.start();
            }
        });

        btnPrivateKey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                privateKey = edtPrivateKey.getText().toString();
            }
        });


        btnOdg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            upitnik.glasaj(0).send();
                            txtView.setText("Glasao za odgovor 0");
                        }
                        catch (Exception e){

                        }
                    }
                });
                thread.start();
            }
        });

        btnOdg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            upitnik.glasaj(1).send();
                            txtView.setText("Glasao za odgovor 1");

                        }catch (Exception e){

                        }
                    }
                });
                thread.start();
            }
        });

        btnOdg3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            upitnik.glasaj(2).send();
                            txtView.setText("Glasao za odgovor 2");

                        }catch (Exception e){

                        }
                    }
                });
                thread.start();
            }
        });

        btnOdg4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            upitnik.glasaj(3).send();
                            txtView.setText("Glasao za odgovor 3");

                        }catch (Exception e){

                        }
                    }
                });
                thread.start();
            }
        });

        btnZavrsiUpitnik.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Thread thread = new Thread(new Runnable() {
                   @Override
                   public void run() {
                       if(upitnik != null) {

                           try {
                               upitnik.krajGlasanja().send();
                               BigInteger id = upitnik.pobednik().send();

                               txtView.setText("Pobednik je odgovor: "  + id);


                           } catch (Exception e) {
                               e.printStackTrace();
                           }
                       }
                   }
               });
               thread.start();

           }
       });

        btnPitaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {

                        try{
                            contractAddress =deployContract(web3j,getCredentialsFromPrivateKey(privateKey),
                                    edtPitanje.getText().toString(),
                                    edtOdg1.getText().toString(),edtOdg2.getText().toString(),
                                    edtOdg3.getText().toString(),edtOdg4.getText().toString());
                            txtView.setText(contractAddress);

                            upitnik = loadContract(contractAddress, web3j, getCredentialsFromPrivateKey(privateKey));

                            upitnik.dozvolaGlasanja(standard_voting_address[0]).send();
                            upitnik.dozvolaGlasanja(standard_voting_address[1]).send();
                            upitnik.dozvolaGlasanja(standard_voting_address[2]).send();
                            upitnik.dozvolaGlasanja(standard_voting_address[3]).send();
                            upitnik.dozvolaGlasanja(standard_voting_address[4]).send();
                            edtPitanje.setText("Sve adrese su dodate !!! Upitnik moze da pocne");

                            String  odg = upitnik.pitanje().send();
                            txtIscitanoPitanje.setText(odg);
                            pair = upitnik.Odgovori(0).send();
                            btnOdg1.setText(pair.getValue1());
                            pair = upitnik.Odgovori(1).send();
                            btnOdg2.setText(pair.getValue1());
                            pair = upitnik.Odgovori(2).send();
                            btnOdg3.setText(pair.getValue1());
                            pair = upitnik.Odgovori(3).send();
                            btnOdg4.setText(pair.getValue1());
                        }catch (Exception e){
                          //  txtView.setText("Nije prosao contract");

                        }
                    }
                });
                thread.start();
            }
        }); // deploy contract


        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            TransactionReceipt transactionReceipt = transfer.sendFunds(
                                    RECIPIENT,
                                    BigDecimal.ONE,
                                    Convert.Unit.ETHER,
                                    GAS_PRICE,
                                    GAS_LIMIT
                            ).send();
                            txtView.setText("Poslato");
                        } catch (Exception e) {
                            e.printStackTrace();
                            txtView.setText(e.toString());
                        }

                    }
                });
            thread.start();
            }
        }); // test connection sent 1 ether to some accound...

         //
        btnAddAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            if(upitnik  != null) {
                                upitnik.dozvolaGlasanja(edtNewAddress.getText().toString());
                            }
                        }catch(Exception e){
                        }
                    }
                });
                thread.start();

            }
        }); // add address


    }
    private Credentials getCredentialsFromPrivateKey(String privateKey){
        return Credentials.create(privateKey);

    }
    public String deployContract(Web3j web3j, Credentials crd,String _pitanje, String _odg1, String _odg2, String _odg3, String _odg4) throws Exception {
        return Upitnik.deploy(web3j,crd,GAS_PRICE,GAS_LIMIT,_pitanje,_odg1,_odg2,_odg3,_odg4).send().getContractAddress();
    }
    private Upitnik loadContract(String contractAddress, Web3j web3j, Credentials credentials){
        return Upitnik.load(contractAddress, web3j, credentials, GAS_PRICE, GAS_LIMIT);
    }

}



/*TO DO :
    - dodaj za svako dugme da iscita vrednosti odgovora.
    - dodaj load contrakta
    - dodaj mogucnost glasanja
    - dodaj kraj upitnika




 */