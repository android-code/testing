class MainActivity : AppCompatActivity() {

    companion object {
        const val NAME = "NAME"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonAction.setOnClickListener {
            val text = editTextName.text.toString()
            if(text.equals("hide"))
                textViewName.visibility = INVISIBLE
            else {
                textViewName.visibility = VISIBLE
                textViewName.text = text
            }
        }

        buttonNavigate.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(NAME, editTextName.text.toString())
            startActivity(intent)
        }

        buttonSms.setOnClickListener {
            val sendIntent = Intent(Intent.ACTION_VIEW)
            sendIntent.data = Uri.parse("sms:")
            sendIntent.putExtra("address", "111222333")
            sendIntent.putExtra("sms_body", textViewName.text)
            startActivity(sendIntent)
        }

        initListView()
    }

    private fun initListView() {
        //ListView with dummy adapter can be replaced by some RecyclerView
        val items: List<String> = listOf("name1", "name2", "name3")
        val adapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        listViewNames.adapter = adapter
        listViewNames.setOnItemClickListener { parent, view, position, id ->  textViewName.text = adapter.getItem(position)}
    }
}