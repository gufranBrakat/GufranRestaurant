package com.saad.gufran.gufranrestaurant;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.saad.gufran.gufranrestaurant.data.Meal;
import com.saad.gufran.gufranrestaurant.data.Product;

import java.util.Arrays;
import java.util.List;

public class ChoicesActivity extends AppCompatActivity {
    private Button btnwgabat;
    private Button btnDrinks;
    private Button btnAppetizer;
    private Button btnSalads;
    private Button btnSweets;
    private Button btnKabala;
    private Meal m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choices);
        btnwgabat = (Button) findViewById(R.id.btnwgabat);
        btnDrinks = (Button) findViewById(R.id.btnDrinks);
        btnAppetizer = (Button) findViewById(R.id.btnAppetizer);
        btnSalads = (Button) findViewById(R.id.btnSalads);
        btnSweets = (Button) findViewById(R.id.btnSweets);
        btnKabala = (Button) findViewById(R.id.btnKabla);
        eventHandler();
        m=new Meal();



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                Intent i3 = new Intent(ChoicesActivity.this, LoginActivity.class);
                startActivity(i3);
                break;

            case R.id.setting:
                break;
        }
        return true;
    }


    private void dataHanler() {

    }






    private void eventHandler() {
        btnDrinks.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                showDrinkDialog();
            }


        });
        btnwgabat.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                showWgabatDialog();
            }


        });
       btnAppetizer.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                showAppetizerDialog();
            }


        });
        btnSalads.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                showSaladsDialog();
            }


        });
        btnSweets.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                showSweetsDialog();
            }


        });




        btnKabala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(ChoicesActivity.this, ReservationActivity.class);

                i1.putExtra("meal",m);
                startActivity(i1);
            }



        });
    }
    private void showDrinkDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ChoicesActivity.this);

        // String array for alert dialog multi choice items
        String[] drinks = new String[]{
                "cola",
                "soda",
                "Lemonade",
                "coffee",
                "water",
                "Nescafe",
                "Tea",
                "Sprite",

        };
        final double[] price = new double[]{
                6,
                6,
                5,
                8,
                5,
                6,
                4,
                6,


        };

        // Boolean array for initial selected items
        final boolean[] checkedDrinks = new boolean[]{
                false, // Red
                false, // Green
                false, // Blue
                false, // Purple
                false, // Olive
                false, //
                false, //
                false,//

        };

        // Convert the color array to list
        final List<String> drinkList = Arrays.asList(drinks);

        // Set multiple choice items for alert dialog
                /*
                    AlertDialog.Builder setMultiChoiceItems(CharSequence[] items, boolean[]
                    checkedItems, DialogInterface.OnMultiChoiceClickListener listener)
                        Set a list of items to be displayed in the dialog as the content,
                        you will be notified of the selected item via the supplied listener.
                 */
                /*
                    DialogInterface.OnMultiChoiceClickListener
                    public abstract void onClick (DialogInterface dialog, int which, boolean isChecked)

                        This method will be invoked when an item in the dialog is clicked.

                        Parameters
                        dialog The dialog where the selection was made.
                        which The position of the item in the list that was clicked.
                        isChecked True if the click checked the item, else false.
                 */
        builder.setMultiChoiceItems(drinks, checkedDrinks, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                // Update the current focused item's checked Status
                checkedDrinks[which] = isChecked;


                // Get the current focused item
                String currentItem = drinkList.get(which);

                // Notify the current action
                Toast.makeText(getApplicationContext(),
                        currentItem + " " + isChecked, Toast.LENGTH_SHORT).show();
            }
        });

        // Specify the dialog is not cancelable
        builder.setCancelable(false);

        // Set a title for alert dialog
        builder.setTitle("Your preferred drinks");

        // Set the positive/yes button click listener
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Do something when click positive button
                // tv.setText("Your preferred colors..... \n");
                for (int i = 0; i < checkedDrinks.length; i++) {
                    boolean checked = checkedDrinks[i];
                    if (checked) {
                        // tv.setText(tv.getText() + colorsList.get(i) + "\n");

                            m.add(new Product(drinkList.get(i), Product.DRINK,price[i]));
                    }
                }
            }
        });

        // Set the negative/no button click listener
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Do something when click the negative button
            }
        });

        // Set the neutral/cancel button click listener
        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Do something when click the neutral button
            }
        });

        AlertDialog dialog = builder.create();
        // Display the alert dialog on interface
        dialog.show();
    }

    private void showWgabatDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ChoicesActivity.this);

        // String array for alert dialog multi choice items
        String[] wgbat = new String[]{
                "kebab",
                "Grilled chicken",
                "",
                "Purple",
                "Olive"
        };
        final double[] price = new double[]{
                9,
                12,
                5,
                8,
                8
        };


        // Boolean array for initial selected items
        final boolean[] checkedwgabt = new boolean[]{
                false, // Red
                false, // Green
                false, // Blue
                false, // Purple
                false // Olive

        };

        // Convert the color array to list
        final List<String> wgbatList = Arrays.asList(wgbat);

        // Set multiple choice items for alert dialog
                /*
                    AlertDialog.Builder setMultiChoiceItems(CharSequence[] items, boolean[]
                    checkedItems, DialogInterface.OnMultiChoiceClickListener listener)
                        Set a list of items to be displayed in the dialog as the content,
                        you will be notified of the selected item via the supplied listener.
                 */
                /*
                    DialogInterface.OnMultiChoiceClickListener
                    public abstract void onClick (DialogInterface dialog, int which, boolean isChecked)

                        This method will be invoked when an item in the dialog is clicked.

                        Parameters
                        dialog The dialog where the selection was made.
                        which The position of the item in the list that was clicked.
                        isChecked True if the click checked the item, else false.
                 */
        builder.setMultiChoiceItems(wgbat, checkedwgabt, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                // Update the current focused item's checked Status
                checkedwgabt[which] = isChecked;

                // Get the current focused item
                String currentItem = wgbatList.get(which);

                // Notify the current action
                Toast.makeText(getApplicationContext(),
                        currentItem + " " + isChecked, Toast.LENGTH_SHORT).show();
            }
        });

        // Specify the dialog is not cancelable
        builder.setCancelable(false);

        // Set a title for alert dialog
        builder.setTitle("Your preferred wgba?");

        // Set the positive/yes button click listener
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Do something when click positive button
                // tv.setText("Your preferred colors..... \n");
                for (int i = 0; i < checkedwgabt.length; i++) {
                    boolean checked =checkedwgabt[i];
                    if (checked) {
                        // tv.setText(tv.getText() + colorsList.get(i) + "\n");
                        m.add(new Product(wgbatList.get(i), Product.Wgabat,price[i]));
                    }
                }
            }
        });

        // Set the negative/no button click listener
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Do something when click the negative button
            }
        });

        // Set the neutral/cancel button click listener
        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Do something when click the neutral button
            }
        });

        AlertDialog dialog = builder.create();
        // Display the alert dialog on interface
        dialog.show();

    }
    private void showAppetizerDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ChoicesActivity.this);

        // String array for alert dialog multi choice items
        String[] appetizer = new String[]{
                "Hamburg",
                "schnitzel",
                "chips",
                "Purple",
                "Olive"
        };
        final double[] price = new double[]{
                9,
                12,
                5,
                8,
                8
        };

        // Boolean array for initial selected items
        final boolean[] checkedAppetizer = new boolean[]{
                false, // Red
                false, // Green
                false, // Blue
                false, // Purple
                false // Olive

        };

        // Convert the color array to list
        final List<String> appetizerList = Arrays.asList(appetizer);

        // Set multiple choice items for alert dialog
                /*
                    AlertDialog.Builder setMultiChoiceItems(CharSequence[] items, boolean[]
                    checkedItems, DialogInterface.OnMultiChoiceClickListener listener)
                        Set a list of items to be displayed in the dialog as the content,
                        you will be notified of the selected item via the supplied listener.
                 */
                /*
                    DialogInterface.OnMultiChoiceClickListener
                    public abstract void onClick (DialogInterface dialog, int which, boolean isChecked)

                        This method will be invoked when an item in the dialog is clicked.

                        Parameters
                        dialog The dialog where the selection was made.
                        which The position of the item in the list that was clicked.
                        isChecked True if the click checked the item, else false.
                 */
        builder.setMultiChoiceItems(appetizer, checkedAppetizer, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                // Update the current focused item's checked Status
                checkedAppetizer[which] = isChecked;

                // Get the current focused item
                String currentItem = appetizerList.get(which);

                // Notify the current action
                Toast.makeText(getApplicationContext(),
                        currentItem + " " + isChecked, Toast.LENGTH_SHORT).show();
            }
        });

        // Specify the dialog is not cancelable
        builder.setCancelable(false);

        // Set a title for alert dialog
        builder.setTitle("Your preferred appetizer?");

        // Set the positive/yes button click listener
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Do something when click positive button
                // tv.setText("Your preferred colors..... \n");
                for (int i = 0; i < checkedAppetizer.length; i++) {
                    boolean checked = checkedAppetizer[i];
                    if (checked) {
                        // tv.setText(tv.getText() + colorsList.get(i) + "\n");
                        m.add(new Product(appetizerList.get(i), Product.Appetizer,price[i]));
                    }
                }
            }
        });

        // Set the negative/no button click listener
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Do something when click the negative button
            }
        });

        // Set the neutral/cancel button click listener
        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Do something when click the neutral button
            }
        });

        AlertDialog dialog = builder.create();
        // Display the alert dialog on interface
        dialog.show();
    }
        private void showSaladsDialog() {
            AlertDialog.Builder builder = new AlertDialog.Builder(ChoicesActivity.this);

            // String array for alert dialog multi choice items
            String[] salad = new String[]{
                    "cabbage salad",
                    "cucumber and totatos",
                    "corn_pickles",
                    "Purple",
                    "Olive"
            };
            final double[] price = new double[]{
                    12,
                    12,
                    13,
                    8,
                    8
            };

            // Boolean array for initial selected items
            final boolean[] checkedsalad = new boolean[]{
                    false, // Red
                    false, // Green
                    false, // Blue
                    false, // Purple
                    false // Olive

            };

            // Convert the color array to list
            final List<String> saladList = Arrays.asList(salad);

            // Set multiple choice items for alert dialog
                /*
                    AlertDialog.Builder setMultiChoiceItems(CharSequence[] items, boolean[]
                    checkedItems, DialogInterface.OnMultiChoiceClickListener listener)
                        Set a list of items to be displayed in the dialog as the content,
                        you will be notified of the selected item via the supplied listener.
                 */
                /*
                    DialogInterface.OnMultiChoiceClickListener
                    public abstract void onClick (DialogInterface dialog, int which, boolean isChecked)

                        This method will be invoked when an item in the dialog is clicked.

                        Parameters
                        dialog The dialog where the selection was made.
                        which The position of the item in the list that was clicked.
                        isChecked True if the click checked the item, else false.
                 */
            builder.setMultiChoiceItems(salad, checkedsalad, new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                    // Update the current focused item's checked Status
                    checkedsalad[which] = isChecked;

                    // Get the current focused item
                    String currentItem = saladList.get(which);

                    // Notify the current action
                    Toast.makeText(getApplicationContext(),
                            currentItem + " " + isChecked, Toast.LENGTH_SHORT).show();
                }
            });

            // Specify the dialog is not cancelable
            builder.setCancelable(false);

            // Set a title for alert dialog
            builder.setTitle("Your preferred salads?");

            // Set the positive/yes button click listener
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // Do something when click positive button
                    // tv.setText("Your preferred colors..... \n");
                    for (int i = 0; i < checkedsalad.length; i++) {
                        boolean checked = checkedsalad[i];
                        if (checked) {
                            // tv.setText(tv.getText() + colorsList.get(i) + "\n");
                            m.add(new Product(saladList.get(i), Product.Salads,price[i]));
                        }
                    }
                }
            });

            // Set the negative/no button click listener
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // Do something when click the negative button
                }
            });

            // Set the neutral/cancel button click listener
            builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // Do something when click the neutral button
                }
            });

            AlertDialog dialog = builder.create();
            // Display the alert dialog on interface
            dialog.show();
        }
            private void showSweetsDialog() {
                AlertDialog.Builder builder = new AlertDialog.Builder(ChoicesActivity.this);

                // String array for alert dialog multi choice items
                String[] sweet = new String[]{
                        "Souffle",
                        "Pavla",
                        "Fruits",
                        "Purple",
                        "Olive"
                };
                final double[] price = new double[]{
                        9,
                        12,
                        5,
                        8,
                        8,
                };

                // Boolean array for initial selected items
                final boolean[] checkedsweet = new boolean[]{
                        false, // Red
                        false, // Green
                        false, // Blue
                        false, // Purple
                        false // Olive

                };

                // Convert the color array to list
                final List<String> sweetList = Arrays.asList(sweet);

                // Set multiple choice items for alert dialog
                /*
                    AlertDialog.Builder setMultiChoiceItems(CharSequence[] items, boolean[]
                    checkedItems, DialogInterface.OnMultiChoiceClickListener listener)
                        Set a list of items to be displayed in the dialog as the content,
                        you will be notified of the selected item via the supplied listener.
                 */
                /*
                    DialogInterface.OnMultiChoiceClickListener
                    public abstract void onClick (DialogInterface dialog, int which, boolean isChecked)

                        This method will be invoked when an item in the dialog is clicked.

                        Parameters
                        dialog The dialog where the selection was made.
                        which The position of the item in the list that was clicked.
                        isChecked True if the click checked the item, else false.
                 */
                builder.setMultiChoiceItems(sweet, checkedsweet, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                        // Update the current focused item's checked Status
                       checkedsweet[which] = isChecked;

                        // Get the current focused item
                        String currentItem = sweetList.get(which);

                        // Notify the current action
                        Toast.makeText(getApplicationContext(),
                                currentItem + " " + isChecked, Toast.LENGTH_SHORT).show();
                    }
                });

                // Specify the dialog is not cancelable
                builder.setCancelable(false);

                // Set a title for alert dialog
                builder.setTitle("Your preferred sweets?");

                // Set the positive/yes button click listener
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Do something when click positive button
                        // tv.setText("Your preferred colors..... \n");
                        for (int i = 0; i < checkedsweet.length; i++) {
                            boolean checked = checkedsweet[i];
                            if (checked) {
                                // tv.setText(tv.getText() + colorsList.get(i) + "\n");
                                m.add(new Product(sweetList.get(i), Product.Sweets,price[i]));
                            }
                        }
                    }
                });

                // Set the negative/no button click listener
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Do something when click the negative button
                    }
                });

                // Set the neutral/cancel button click listener
                builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Do something when click the neutral button
                    }
                });

                AlertDialog dialog = builder.create();
                // Display the alert dialog on interface
                dialog.show();
            }


        }







