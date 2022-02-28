package dev.dsi.robust.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import dev.dsi.robust.R
import dev.dsi.robust.databinding.FragmentAboutBinding


class AboutFragment : Fragment() {
    private var _binding: FragmentAboutBinding? = null
    private val binding
    get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAboutBinding.inflate(inflater, container, false)

        //Madhur
        binding.textGithubOne.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://github.com/madhurmehta007")
            startActivity(openURL)
        }
        binding.textLinkedInOne.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.linkedin.com/in/madhurmehta007/")
            startActivity(openURL)
        }

        //Debayan
        binding.textGithubTwo.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://github.com/debz-g")
            startActivity(openURL)
        }
        binding.textLinkedInTwo.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.linkedin.com/in/debzexe/")
            startActivity(openURL)
        }

        //Saalim
        binding.textGithubThree.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://github.com/danascape")
            startActivity(openURL)
        }
        binding.textLinkedInThree.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.linkedin.com/in/saalim-quadri/")
            startActivity(openURL)
        }

        //Manasvi
        binding.textGithubFour.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://github.com/Manasvikashyap")
            startActivity(openURL)
        }
        binding.textGmailOne.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("mailto:manasvigk03@gmail.com")
            startActivity(openURL)
        }

        //Joyeeta
        binding.textGMailTwo.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("mailto:joyeeta2811.bais@gmail.com")
            startActivity(openURL)
        }
        binding.textLinkedInFive.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.linkedin.com/in/joyeeta-bais-722727231")
            startActivity(openURL)
        }

        //Maithri
        binding.textGithub4.setOnClickListener {
            Toast.makeText(requireContext(),"Not yet updated", Toast.LENGTH_SHORT).show()
        }
        binding.textLinkedIn4.setOnClickListener {
            Toast.makeText(requireContext(),"Not yet updated", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }

}