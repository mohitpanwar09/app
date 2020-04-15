package com.example.restaurantmenuapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.food_ticket.view.*

class MainActivity : AppCompatActivity() {

    var adapter:FoodAdaptor?=null
    var listOfFood =ArrayList<food>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
// deceleration of images and name and des to the class food


        listOfFood.add(food("BURGER","A hamburger is a sandwich consisting of one or more cooked" +
                " patties of ground meat, usually beef, placed inside a slic" +
                "ed bread roll or bun. The patty may be pan fried, grilled, smoked or flame broiled.",R.drawable.burger))
        listOfFood.add(food("CHILL POTATO","Chilli potato is a Indo chinese starter made with fried potatoes " +
                "tossed in spicy, slightly sweet & sour chilli sauce. ",R.drawable.chill_potato))
        listOfFood.add(food("CHAAP ROLL","Great recipe for Soya chaap roll. Soya has lots of protein " +
                "I hope you guys like it this recepie is good for kids as well as elders.",R.drawable.`chaap_roll`))
        listOfFood.add(food("DOSA","A dosa is a cooked rice pancake, originating from Sou" +
                "th India, made from a fermented batter. It is somewhat similar to a crepe in appearance",R.drawable.dosa))
        listOfFood.add(food("KFC","KFC (short for Kentucky Fried Chicken) is an American fast food chain " +
                "(as measured by sales) after McDonald's, with 22,621 locations globally in 136 countries as of December 2018.",R.drawable.kfc))
        listOfFood.add(food("MAGGI","Maggi is a product that belongs to Nestle India, which is one of the leadin" +
                " Maggi products that are manufactured by Nestlé include instant noodles, stocks, instant soups and ketchups.",R.drawable.maggi))
        listOfFood.add(food("MOMOS","Momo is a type of South Asian steamed filled dumpling, popular across " +
                "the Indian subcontinent and the Himalayan regions of broader South Asia.",R.drawable.momos))
        listOfFood.add(food("NOODLE","Noodles are a type of food made from unleavened dough which is " +
                "rolled flat and cut, stretched or extruded,",R.drawable.noodle))
        listOfFood.add(food("PASTA","Pasta (US: /ˈpɑːstə/, UK: /ˈpæstə/; Italian pronunciation: " +
                "[ˈpasta]) is a type of food typically made from an unleavened dough of wheat",R.drawable.pasta))
        listOfFood.add(food("PIZZA","Pizza (Italian: " +
                "[ˈpittsa], Neapolitan: [ˈpittsə]) is a savory dish of Italian origin, consisting",R.drawable.pizza))

            adapter= FoodAdaptor(this,listOfFood)

        gridview.adapter=adapter

    }


    // Now we have to define adaptor class

    class FoodAdaptor:BaseAdapter{

        var ListOfFood=ArrayList<food>()
        var context:Context?=null
        constructor(context: Context,ListOfFood:ArrayList<food>):super(){
            this.context=context
            this.ListOfFood=ListOfFood
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
                    // NOw we have to assigne the ticket value to the main view
                    val foodf=this.ListOfFood[position]
            var inflater=context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var foodvie =inflater.inflate(R.layout.food_ticket,null)
                foodvie.ivfood.setImageResource(foodf.image!!)
            foodvie.ivfood.setOnClickListener {
                val intent=Intent(context,fooddetails::class.java)
                intent.putExtra("name",foodf.name!!)
                intent.putExtra("des",foodf.des!!)
                intent.putExtra("Image",foodf.image!!)
                context!!.startActivity(intent)
            }
                foodvie.tvname.text=(foodf.name!!)
            return foodvie
        }

        override fun getItem(position: Int): Any {
           return  ListOfFood[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            /// this count the element in the arraylist
            return ListOfFood.size
        }

    }

}
