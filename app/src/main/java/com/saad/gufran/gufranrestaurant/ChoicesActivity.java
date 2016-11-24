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
        String[] colors = new String[]{
                "Red",
                "Green",
                "Blue",
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
        final boolean[] checkedDrinks = new boolean[]{
                false, // Red
                false, // Green
                false, // Blue
                false, // Purple
                false // Olive

        };

        // Convert the color array to list
        final List<String> colorsList = Arrays.asList(colors);

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
        builder.setMultiChoiceItems(colors, checkedDrinks, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                // Update the current focused item's checked status
                checkedDrinks[which] = isChecked;


                // Get the current focused item
                String currentItem = colorsList.get(which);

                // Notify the current action
                Toast.makeText(getApplicationContext(),
                        currentItem + " " + isChecked, Toast.LENGTH_SHORT).show();
            }
        });

        // Specify the dialog is not cancelable
        builder.setCancelable(false);

        // Set a title for alert dialog
        builder.setTitle("Your preferred colors?");

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

                            m.add(new Product(colorsList.get(i), Product.DRINK,price[i]));
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
        String[] colors = new String[]{
                "Red111",
                "Green",
                "Blue",
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
        final boolean[] checkedColors = new boolean[]{
                false, // Red
                false, // Green
                false, // Blue
                false, // Purple
                false // Olive

        };

        // Convert the color array to list
        final List<String> colorsList = Arrays.asList(colors);

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
        builder.setMultiChoiceItems(colors, checkedColors, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                // Update the current focused item's checked status
                checkedColors[which] = isChecked;

                // Get the current focused item
                String currentItem = colorsList.get(which);

                // Notify the current action
                Toast.makeText(getApplicationContext(),
                        currentItem + " " + isChecked, Toast.LENGTH_SHORT).show();
            }
        });

        // Specify the dialog is not cancelable
        builder.setCancelable(false);

        // Set a title for alert dialog
        builder.setTitle("Your preferred colors?");

        // Set the positive/yes button click listener
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Do something when click positive button
                // tv.setText("Your preferred colors..... \n");
                for (int i = 0; i < checkedColors.length; i++) {
                    boolean checked = checkedColors[i];
                    if (checked) {
                        // tv.setText(tv.getText() + colorsList.get(i) + "\n");
                        m.add(new Product(colorsList.get(i), Product.Wgabat,price[i]));
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
        String[] colors = new String[]{
                "Red222",
                "Green",
                "Blue",
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
        final boolean[] checkedColors = new boolean[]{
                false, // Red
                false, // Green
                false, // Blue
                false, // Purple
                false // Olive

        };

        // Convert the color array to list
        final List<String> colorsList = Arrays.asList(colors);

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
        builder.setMultiChoiceItems(colors, checkedColors, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                // Update the current focused item's checked status
                checkedColors[which] = isChecked;

                // Get the current focused item
                String currentItem = colorsList.get(which);

                // Notify the current action
                Toast.makeText(getApplicationContext(),
                        currentItem + " " + isChecked, Toast.LENGTH_SHORT).show();
            }
        });

        // Specify the dialog is not cancelable
        builder.setCancelable(false);

        // Set a title for alert dialog
        builder.setTitle("Your preferred colors?");

        // Set the positive/yes button click listener
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Do something when click positive button
                // tv.setText("Your preferred colors..... \n");
                for (int i = 0; i < checkedColors.length; i++) {
                    boolean checked = checkedColors[i];
                    if (checked) {
                        // tv.setText(tv.getText() + colorsList.get(i) + "\n");
                        m.add(new Product(colorsList.get(i), Product.Appetizer,price[i]));
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
            String[] colors = new String[]{
                    "Red333",
                    "Green",
                    "Blue",
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
            final boolean[] checkedColors = new boolean[]{
                    false, // Red
                    false, // Green
                    false, // Blue
                    false, // Purple
                    false // Olive

            };

            // Convert the color array to list
            final List<String> colorsList = Arrays.asList(colors);

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
            builder.setMultiChoiceItems(colors, checkedColors, new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                    // Update the current focused item's checked status
                    checkedColors[which] = isChecked;

                    // Get the current focused item
                    String currentItem = colorsList.get(which);

                    // Notify the current action
                    Toast.makeText(getApplicationContext(),
                            currentItem + " " + isChecked, Toast.LENGTH_SHORT).show();
                }
            });

            // Specify the dialog is not cancelable
            builder.setCancelable(false);

            // Set a title for alert dialog
            builder.setTitle("Your preferred colors?");

            // Set the positive/yes button click listener
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // Do something when click positive button
                    // tv.setText("Your preferred colors..... \n");
                    for (int i = 0; i < checkedColors.length; i++) {
                        boolean checked = checkedColors[i];
                        if (checked) {
                            // tv.setText(tv.getText() + colorsList.get(i) + "\n");
                            m.add(new Product(colorsList.get(i), Product.Salads,price[i]));
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
                String[] colors = new String[]{
                        "Red444",
                        "Green",
                        "Blue",
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
                final boolean[] checkedColors = new boolean[]{
                        false, // Red
                        false, // Green
                        false, // Blue
                        false, // Purple
                        false // Olive

                };

                // Convert the color array to list
                final List<String> colorsList = Arrays.asList(colors);

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
                builder.setMultiChoiceItems(colors, checkedColors, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                        // Update the current focused item's checked status
                        checkedColors[which] = isChecked;

                        // Get the current focused item
                        String currentItem = colorsList.get(which);

                        // Notify the current action
                        Toast.makeText(getApplicationContext(),
                                currentItem + " " + isChecked, Toast.LENGTH_SHORT).show();
                    }
                });

                // Specify the dialog is not cancelable
                builder.setCancelable(false);

                // Set a title for alert dialog
                builder.setTitle("Your preferred colors?");

                // Set the positive/yes button click listener
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Do something when click positive button
                        // tv.setText("Your preferred colors..... \n");
                        for (int i = 0; i < checkedColors.length; i++) {
                            boolean checked = checkedColors[i];
                            if (checked) {
                                // tv.setText(tv.getText() + colorsList.get(i) + "\n");
                                m.add(new Product(colorsList.get(i), Product.Sweets,price[i]));
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







