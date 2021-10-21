import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.themoviedb.movies.PopularMoviesFragment
import com.example.themoviedb.movies.TopRatedFragment

class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> PopularMoviesFragment()
            1 -> TopRatedFragment()
            else -> PopularMoviesFragment()
        }
    }
}