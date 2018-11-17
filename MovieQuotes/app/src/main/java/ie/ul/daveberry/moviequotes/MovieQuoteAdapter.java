package ie.ul.daveberry.moviequotes;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.firestore.DocumentSnapshot;

import org.w3c.dom.Text;

public class MovieQuoteAdapter extends RecyclerView.Adapter<MovieQuoteAdapter.MovieQuoteViewHolder>{


    @NonNull
    @Override
    public MovieQuoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.moivequote_itemview, parent, false);
        return new MovieQuoteViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieQuoteViewHolder movieQuoteViewHolder, int i) {
        DocumentSnapshot ds = mMovieQuoteSnapshots.get(i);
        String quote = (String)ds.get(Constants.KEY_QUOTE);
        String movie = (String)ds.get(Constants.KEY_MOVIE);
        movieQuoteViewHolder.mQuoteTextView.setText(quote);
        movieQuoteViewHolder.mMovieTextView.setText(movie);
    }

    @Override
    public int getItemCount() {
        return mMovieQuoteSnapshots.size();
    }

    class MovieQuoteViewHolder extends RecyclerView.ViewHolder{
        private TextView mQuoteTextView;
        private TextView mMovieTextView;
        public MovieQuoteViewHolder(@NonNull View itemView) {
            super(itemView);
            mQuoteTextView = itemView.findViewById(R.id.itemview_quote);
            mMovieTextView = itemView.findViewById(R.id.itemview_movie);


        }
    }
}
