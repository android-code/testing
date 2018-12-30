class MainActivity : AppCompatActivity() {

    companion object {
        const val TITLE_KEY = "TITLE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonAction.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        textViewTitle.setOnClickListener { textViewTitle.setText(R.string.clicked) }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState?.let {
            if(it.containsKey(TITLE_KEY))
                textViewTitle.text = it.getString(TITLE_KEY)
        }
    }
}