package com.androideity.greendroidtest;

import greendroid.app.GDActivity;
import greendroid.widget.ActionBarItem;
import greendroid.widget.QuickAction;
import greendroid.widget.QuickActionBar;
import greendroid.widget.QuickActionWidget;
import greendroid.widget.ActionBarItem.Type;
import greendroid.widget.QuickActionWidget.OnQuickActionClickListener;
import android.os.Bundle;
import android.widget.Toast;

public class GreenDroidTestActivity extends GDActivity {
	private final int LOCATE = 0;
	private final int REFRESH = 1;
	private final int SHARE = 2;
	private QuickActionBar quickActions;
    
    /** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setActionBarContentView(R.layout.main);
		initActionBar();
		initQuickActionBar();
	}

	private void initActionBar() {
		addActionBarItem(Type.Locate, LOCATE);
		addActionBarItem(Type.Refresh, REFRESH);
		addActionBarItem(Type.Share, SHARE);
	}

	@Override
	public boolean onHandleActionBarItemClick(ActionBarItem item, int position) {
		switch (item.getItemId()) {
		case LOCATE:
			Toast.makeText(getApplicationContext(),
					"Has pulsado el boton LOCATE", Toast.LENGTH_SHORT).show();
			break;

		case REFRESH:
			Toast.makeText(getApplicationContext(),
					"Has pulsado el boton REFRESH", Toast.LENGTH_SHORT).show();
			break;

		case SHARE:
			quickActions.show(item.getItemView());
			Toast.makeText(getApplicationContext(),
					"Has pulsado el boton SHARE", Toast.LENGTH_SHORT).show();
			break;
		default:
			return super.onHandleActionBarItemClick(item, position);
		}

		return true;
	}

	private void initQuickActionBar() {
		quickActions = new QuickActionBar(this);
		quickActions.addQuickAction(new QuickAction(this, R.drawable.buscar,
				"Buscar"));
		quickActions.addQuickAction(new QuickAction(this, R.drawable.tags,
				"Tags"));
		quickActions.addQuickAction(new QuickAction(this, R.drawable.mail,
				"Email"));
		quickActions
				.setOnQuickActionClickListener(new OnQuickActionClickListener() {
					public void onQuickActionClicked(QuickActionWidget widget,
							int position) {
						Toast.makeText(GreenDroidTestActivity.this,
								"Item " + position + " pulsado",
								Toast.LENGTH_SHORT).show();
					}
				});
	}
   }