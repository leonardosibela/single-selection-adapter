package br.com.sibela.singleselectionadapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

public class StringAdapter extends RecyclerView.Adapter<StringAdapter.StringViewHolder> {

    private List<String> strings;
    private Integer selectedPosition;
    private boolean userClicked = true;

    public StringAdapter(List<String> strings) {
        this.strings = strings;
    }

    @NonNull
    @Override
    public StringViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.string_item, parent, false);
        return new StringViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final StringViewHolder holder, final int position) {
        String string = strings.get(position);
        holder.rewardText.setText(string);

        if (selectedPosition != null && selectedPosition == position) {
            holder.checkbox.setChecked(true);
        } else {
            holder.checkbox.setChecked(false);
        }

        holder.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkAndUncheck(isChecked, position);
            }
        });
    }

    private void checkAndUncheck(boolean isChecked, int position) {
        if (!userClicked) {
            userClicked = true;
            return;
        }

        if (isChecked) {
            if (selectedPosition != null) {
                int oldPosition = selectedPosition;
                userClicked = false;
                selectedPosition = position;
                notifyItemChanged(oldPosition);
            }
            selectedPosition = position;
        } else {
            selectedPosition = null;
        }
    }

    @Override
    public int getItemCount() {
        return strings == null ? 0 : strings.size();
    }

    static class StringViewHolder extends RecyclerView.ViewHolder {

        TextView rewardText;
        CheckBox checkbox;

        StringViewHolder(View view) {
            super(view);
            rewardText = view.findViewById(R.id.text);
            checkbox = view.findViewById(R.id.checkbox);
        }
    }
}